package com.solvd.carservice.dao.mysql;

import com.solvd.carservice.dao.IUserDAO;
import com.solvd.carservice.model.User;
import com.solvd.carservice.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractMysqlDAO implements IUserDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static final String GET_USER = "SELECT * FROM Users Where id = ?";
    private static final String ADD_USER = "INSERT INTO Users (first_name, last_name, id_number, phone, email," +
            " address, member_since) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE Users SET first_name = ?, last_name = ?," +
            " address = ?, email = ?, id_number = ?, phone = ?, member_since = ? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM Users WHERE id = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM Users";

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
            LOGGER.info(e);
            return null;
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public Object createEntity(Object entity) {
        if (!(entity instanceof User)) {
            return null;
        }
        User user = (User) entity;
        Connection connection = ConnectionPool.getInstance().retrieve();
        try (PreparedStatement statement = connection.prepareStatement(ADD_USER, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getIdNumber());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getAddress());
            statement.setDate(7, (Date) user.getMemberSince());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong(1));
            }
            return user;
        } catch (SQLException e) {
            LOGGER.info(e);
            return null;
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }



    @Override
    public Object updateEntity(Object entity) {
        User user = (User) entity;
        Connection connection = ConnectionPool.getInstance().retrieve();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getIdNumber());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getAddress());
            statement.setDate(7, new java.sql.Date(user.getMemberSince().getTime()));
            statement.setLong(8, user.getId());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            LOGGER.info(e);
            return null;
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public void removeEntity(Object entity) {
        User user = (User) entity;
        Connection connection = ConnectionPool.getInstance().retrieve();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setLong(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setIdNumber(resultSet.getString("id_number"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setEmail(resultSet.getString("email"));
                    user.setAddress(resultSet.getString("address"));
                    user.setMemberSince(resultSet.getDate("member_since"));
                    users.add(user);
                }
                return users;
            }
        } catch (SQLException e) {
            LOGGER.info(e);
            return null;
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }
}
