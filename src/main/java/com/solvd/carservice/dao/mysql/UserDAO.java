package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IUserDAO;
import com.solvd.carservice.model.User;
import com.solvd.carservice.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractMysqlDAO implements IUserDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static final String GET_USER = "SELECT * FROM Users Where id = ?";
    @Override
    public Object getEntityById(long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        User u = new User();
        try (PreparedStatement statement = connection.prepareStatement(GET_USER)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    u.setFirstName(resultSet.getString("first_name"));
                    u.setLastName(resultSet.getString("last_name"));
                    u.setAddress(resultSet.getString("address"));
                    u.setEmail(resultSet.getString("email"));
                    u.setIdNumber(resultSet.getString("id_number"));
                    u.setPhone(resultSet.getString("phone"));
                    u.setMemberSince(resultSet.getDate("member_since"));
                    return u;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            ConnectionPool.getInstance().putback(connection);
            LOGGER.info(e);
            return null;
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
