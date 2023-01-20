package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IServiceOrderDAO;
import com.solvd.carservice.model.ServiceOrder;

import java.util.List;

public class ServiceOrderDAO extends AbstractMysqlDAO implements IServiceOrderDAO {
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
        return null;
    }
}
