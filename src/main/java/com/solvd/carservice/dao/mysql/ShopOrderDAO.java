package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IShopOrderDAO;
import com.solvd.carservice.enums.OrderStatus;
import com.solvd.carservice.enums.ServiceStatus;
import com.solvd.carservice.model.ServiceOrder;
import com.solvd.carservice.model.ShopOrder;
import com.solvd.carservice.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopOrderDAO extends AbstractMysqlDAO implements IShopOrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static final String GET_SHOP_ORDERS_BY_USER_ID = "SELECT * FROM Shop_orders Where user_id = ?";
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
    public List<ShopOrder> getShopOrdersByUserId(long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<ShopOrder> shopOrders = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_SHOP_ORDERS_BY_USER_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ShopOrder shopOrder = new ShopOrder();
                    shopOrder.setId(resultSet.getLong("id"));
                    shopOrder.setUserId(resultSet.getLong("user_id"));
                    shopOrder.setShopId(resultSet.getLong("shop_id"));
                    shopOrder.setCarPartsId(resultSet.getLong("car_parts_id"));
                    shopOrder.setDate(resultSet.getDate("date"));
                    shopOrder.setOrderStatus(OrderStatus.valueOf(resultSet.getString("order_status").toUpperCase()));
                    shopOrders.add(shopOrder);
                    return shopOrders;
                }
            }
        } catch (SQLException e) {
            ConnectionPool.getInstance().putback(connection);
            LOGGER.info(e);
            return null;
        }
        return shopOrders;
    }
}
