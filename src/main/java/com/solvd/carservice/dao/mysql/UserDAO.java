package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IUserDAO;
import com.solvd.carservice.model.User;
import com.solvd.carservice.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractMysqlDAO implements IUserDAO {
    private final static String GET_USER = "SELECT * FROM Users Where id = ?";
    @Override
    public Object getEntityById(long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        User u = new User();
        try (PreparedStatement statement = connection.prepareStatement(GET_USER)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int userId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    return u;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            ConnectionPool.getInstance().putback(connection);
            throw new RuntimeException(e);
        } finally{
            // TODO
            // where to close rs and ps?
            // do we need connection put back here too?
        }

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
