package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IUserDAO;
import com.solvd.carservice.model.User;

import java.util.List;

public class UserDAO extends AbstractMysqlDAO implements IUserDAO {
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
    public List<User> getAllUsers() {
        return null;
    }
}
