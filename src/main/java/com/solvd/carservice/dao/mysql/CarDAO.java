package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.ICarBrandDAO;
import com.solvd.carservice.dao.ICarDAO;
import com.solvd.carservice.model.Car;

import java.util.List;

public class CarDAO extends AbstractMysqlDAO implements ICarDAO {
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
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Car getCarByUserId(long userId) {
        return null;
    }

    @Override
    public List<Car> getCarsByUserId(long id) {
        return null;
    }
}
