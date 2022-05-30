package uz.epam.webproject.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {

    INSTANCE;

    private static final Logger logger = LogManager.getLogger();
    private static final int POOL_SIZE = 10;
    private static final String DATABASE_PROPERTIES_FILE = "/config/database.properties";
    private static final String DRIVER = "driver";
    private static final String DATABASE_URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private final BlockingQueue<ProxyConnection> freeConnections;
    private final BlockingQueue<ProxyConnection> busyConnections;

    ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(POOL_SIZE);
        busyConnections = new LinkedBlockingDeque<>(POOL_SIZE);

        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(DATABASE_PROPERTIES_FILE);

        try {
            properties.load(inputStream);
            Class.forName(properties.getProperty(DRIVER));
        } catch (IOException | ClassNotFoundException exception) {
//            logger.fatal("error in loading driver class or class not found", exception);
            throw new ExceptionInInitializerError(exception);
        }

            for (int i = 0; i < POOL_SIZE; i++) {
                ProxyConnection proxyConnection;
                try {
                    proxyConnection = new ProxyConnection(DriverManager.getConnection(properties.getProperty(DATABASE_URL), properties
                                    /*properties.getProperty(USER), properties.getProperty(PASSWORD))*/));
                } catch (SQLException sqlException) {
//            logger.fatal("error in loading connection", sqlException);
                    throw new ExceptionInInitializerError(sqlException);
                }
                freeConnections.add(proxyConnection);
            }
    }

    public Connection getConnection(){
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            busyConnections.put(connection);
        } catch (InterruptedException interruptedException) {
            logger.error("error in getting connection ", interruptedException);
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection){
        try {
            if (connection instanceof ProxyConnection /*connection1 */&& (busyConnections.remove(connection))) {
                freeConnections.put((ProxyConnection) connection);
            }
        } catch (InterruptedException interruptedException) {
            logger.error("error in releasing connection ", interruptedException);
            Thread.currentThread().interrupt();
        }
    }

    public void destroyPool() {
        for (int i = 0; i < POOL_SIZE; i++){
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException interruptedException) {
                logger.error("error in destroying pools ", interruptedException);
                Thread.currentThread().interrupt();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> deregisterDrivers());
    }
}
