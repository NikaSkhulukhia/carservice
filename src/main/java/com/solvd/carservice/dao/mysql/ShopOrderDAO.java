package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IShopOrderDAO;
import com.solvd.carservice.model.ShopOrder;

import java.util.List;

public class ShopOrderDAO extends AbstractMysqlDAO implements IShopOrderDAO {
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
