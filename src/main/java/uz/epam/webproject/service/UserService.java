package uz.epam.webproject.service;

import uz.epam.webproject.entity.user.User;
import uz.epam.webproject.entity.user.UserRole;
import uz.epam.webproject.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean authenticate(String login, String email) throws ServiceException;

    List<User> findAll()throws ServiceException;

    Optional<User> findByLogin(String login) throws ServiceException;

    UserRole findUserRole(String login)throws ServiceException;

    boolean checkLogin(String login) throws ServiceException;

    boolean updatePassword(String login, String newPassword) throws ServiceException;


}
