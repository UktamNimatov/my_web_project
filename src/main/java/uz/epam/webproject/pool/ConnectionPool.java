package uz.epam.webproject.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {

    INSTANCE;

    private final Logger logger = LogManager.getLogger();
    private static final int POOL_SIZE = 10;
    private static final String DATABASE_PROPERTIES = "config/database.properties";
    private static final String DRIVER = "driver";
    private static final String DATABASE_URL = "url";

    private final BlockingQueue<ProxyConnection> freeConnections;
    private final Queue<ProxyConnection> busyConnections;

    ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(POOL_SIZE);
        busyConnections = new ArrayDeque<>(POOL_SIZE);

        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(DATABASE_PROPERTIES);

        try {
            properties.load(inputStream);
            Class.forName(properties.getProperty(DRIVER));
        } catch (IOException | ClassNotFoundException exception) {
            logger.error("error in loading driver class or class not found", exception);
            throw new ExceptionInInitializerError(exception);
        }

        try {
            for (int i = 0; i < POOL_SIZE; i++){
                freeConnections.offer(new ProxyConnection(DriverManager.getConnection(DATABASE_URL, properties)));
            }
        } catch (SQLException sqlException) {
            logger.error("error in loading driver", sqlException);
            Thread.currentThread().interrupt();
        }
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = freeConnections.take();
            busyConnections.offer(new ProxyConnection(connection));
        } catch (InterruptedException interruptedException) {
            logger.error("error in getting connection ", interruptedException);
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection){
        try {
            if (connection instanceof ProxyConnection && (busyConnections.remove(connection))) {
                freeConnections.put(new ProxyConnection(connection));
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
