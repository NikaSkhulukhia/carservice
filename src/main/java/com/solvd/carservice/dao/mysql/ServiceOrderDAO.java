package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IServiceOrderDAO;
import com.solvd.carservice.enums.Color;
import com.solvd.carservice.enums.ServiceStatus;
import com.solvd.carservice.model.Car;
import com.solvd.carservice.model.ServiceOrder;
import com.solvd.carservice.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceOrderDAO extends AbstractMysqlDAO implements IServiceOrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static final String GET_SERVICE_ORDERS_BY_USER_ID = "SELECT * FROM Service_orders Where user_id = ?";
    @Override
    public Object getEntityById(long id) {
        return null;
    }

    @Override
    public Object createEntity(Object entity) {
        return null;
    }

    @Override
    public Object updateEntity(Object entity) {
        return null;
    }

    @Override
    public void removeEntity(Object entity) {

    }

    @Override
    public List<ServiceOrder> getServiceOrdersByUserId(long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<ServiceOrder> serviceOrders = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_SERVICE_ORDERS_BY_USER_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ServiceOrder serviceOrder = new ServiceOrder();
                    serviceOrder.setId(resultSet.getLong("id"));
                    serviceOrder.setServiceStationId(resultSet.getLong("id"));
                    serviceOrder.setCarId(resultSet.getLong("id"));
                    serviceOrder.setCarServiceId(resultSet.getLong("id"));
                    serviceOrder.setDate(resultSet.getDate("id"));
                    serviceOrder.setUserId(resultSet.getLong("id"));
                    serviceOrder.setServiceStatus(ServiceStatus.valueOf(resultSet.getString("id").toUpperCase()));
                    serviceOrders.add(serviceOrder);
                    return serviceOrders;
                }
            }
        } catch (SQLException e) {
            ConnectionPool.getInstance().putback(connection);
            LOGGER.info(e);
            return null;
        }
        return serviceOrders;
    }
}
