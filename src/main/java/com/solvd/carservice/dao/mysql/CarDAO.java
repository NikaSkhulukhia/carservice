package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.ICarDAO;
import com.solvd.carservice.enums.Color;
import com.solvd.carservice.model.Car;
import com.solvd.carservice.model.User;
import com.solvd.carservice.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends AbstractMysqlDAO implements ICarDAO {
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
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Car getCarByUserId(long userId) {
        return null;
    }

    @Override
    public List<Car> getCarsByUserId(long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_CARS_BY_USER_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Car c = new Car();
                    c.setUserId(resultSet.getLong("user_id"));
                    c.setId(resultSet.getLong("id"));
                    c.setYear(resultSet.getDate("year"));
                    c.setCarBrandId(resultSet.getLong("car_brand_id"));
                    c.setBrandModelId(resultSet.getLong("brand_model_id"));
                    c.setLicensePlate(resultSet.getString("license_plate"));
                    c.setCurrentMileage(resultSet.getString("current_mileage"));
                    c.setColor(Color.valueOf(resultSet.getString("color").toUpperCase()));
                    cars.add(c);
                    return cars;
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
            return null;
        } finally{
            ConnectionPool.getInstance().putback(connection);
        }
        return cars;
    }
}
