package uz.epam.webproject.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.dao.UserDao;
import uz.epam.webproject.dao.exception.DaoException;
import uz.epam.webproject.entity.user.User;
import uz.epam.webproject.entity.user.UserRole;
import uz.epam.webproject.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao<User> {
    private static final Logger logger = LogManager.getLogger();

    private static UserDaoImpl instance;

    public static UserDaoImpl getInstance() {
        if (instance == null){
            return instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean authenticate(String login, String email) throws DaoException {
        return false;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<User> findByLogin(String login) throws DaoException {
        return Optional.empty();
    }

    @Override
    public UserRole findUserRole(String login) throws DaoException {
        return null;
    }

    @Override
    public boolean checkLogin(String login) throws DaoException {
        return false;
    }

    @Override
    public boolean updatePassword(String login, String newPassword) throws DaoException {
        return false;
    }
}
