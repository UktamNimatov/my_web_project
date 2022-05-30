package uz.epam.webproject.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.dao.UserDao;
import uz.epam.webproject.dao.exception.DaoException;
import uz.epam.webproject.dao.impl.UserDaoImpl;
import uz.epam.webproject.entity.user.User;
import uz.epam.webproject.entity.user.UserRole;
import uz.epam.webproject.service.UserService;
import uz.epam.webproject.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();

    private static UserServiceImpl instance;

    public static UserServiceImpl getInstance() {
        if (instance == null){
            return instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean authenticate(String login, String email) throws ServiceException {
        UserDao<User> userDao = UserDaoImpl.getInstance();
        boolean match;
        try {
            match = userDao.authenticate(login, email);
            logger.info(match);
        } catch (DaoException e) {
            logger.error("error in authenticating the user", e);
            throw new ServiceException(e);
        }
        return match;
    }

    @Override
    public List<User> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public UserRole findUserRole(String login) throws ServiceException {
        return null;
    }

    @Override
    public boolean checkLogin(String login) throws ServiceException {
        return false;
    }

    @Override
    public boolean updatePassword(String login, String newPassword) throws ServiceException {
        return false;
    }
}
