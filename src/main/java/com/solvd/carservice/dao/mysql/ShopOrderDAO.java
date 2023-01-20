package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IShopOrderDAO;
import com.solvd.carservice.model.ShopOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShopOrderDAO extends AbstractMysqlDAO implements IShopOrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static final String GET_CARS_BY_USER_ID = "SELECT * FROM Cars Where user_id = ?";
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
        return null;
    }
}
