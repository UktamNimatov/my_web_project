package uz.epam.webproject.dao.mapper.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.dao.exception.DaoException;
import uz.epam.webproject.dao.mapper.ColumnName;
import uz.epam.webproject.dao.mapper.EntityMapper;
import uz.epam.webproject.entity.order.Order;
import uz.epam.webproject.entity.order.OrderStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class OrderMapper implements EntityMapper<Order> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<Order> map(ResultSet resultSet) throws DaoException {
        try {
            Order order = new Order();
            order.setId(resultSet.getInt(ColumnName.ID));
            order.setUserId(resultSet.getInt(ColumnName.USER_ID));
            order.setStatus(OrderStatus.valueOf(resultSet.getString(ColumnName.STATUS).toUpperCase()));
            order.setOrderedTime(resultSet.getTimestamp(ColumnName.ORDERED_TIME));
            order.setConfirmedTime(resultSet.getTimestamp(ColumnName.CONFIRMED_TIME));
            order.setCompletedTime(resultSet.getTimestamp(ColumnName.COMPLETED_TIME));
            order.setCanceledTime(resultSet.getTimestamp(ColumnName.CANCELED_TIME));
            return Optional.of(order);
        } catch (SQLException sqlException) {
            logger.error("error in mapping resultSet into an object", sqlException);
//            return Optional.empty();
            throw new DaoException(sqlException); //fixme!
        }
    }
}
