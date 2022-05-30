package uz.epam.webproject.dao.mapper;

import uz.epam.webproject.dao.exception.DaoException;

import java.sql.ResultSet;
import java.util.Optional;

public interface EntityMapper<T> {

    Optional<T> map(ResultSet resultSet) throws DaoException;
}
