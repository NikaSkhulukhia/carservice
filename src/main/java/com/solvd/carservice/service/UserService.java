package com.solvd.carservice.service;

import com.solvd.carservice.dao.ICarDAO;
import com.solvd.carservice.dao.IServiceOrderDAO;
import com.solvd.carservice.dao.IShopOrderDAO;
import com.solvd.carservice.dao.IUserDAO;
import com.solvd.carservice.dao.mysql.CarDAO;
import com.solvd.carservice.dao.mysql.ServiceOrderDAO;
import com.solvd.carservice.dao.mysql.ShopOrderDAO;
import com.solvd.carservice.dao.mysql.UserDAO;
import com.solvd.carservice.model.User;

import java.util.List;

public class UserService {
    private IUserDAO uDAO = new UserDAO();
    private ICarDAO cDAO = new CarDAO();
    private IServiceOrderDAO servOrderDAO = new ServiceOrderDAO();
    private IShopOrderDAO shopOrderDAO = new ShopOrderDAO();

    public User getUserById(long id){
        User u = (User) uDAO.getEntityById(id);
        u.setCars(cDAO.getCarsByUserId(id));
        u.setServiceOrders(servOrderDAO.getServiceOrdersByUserId(id));
        u.setShopOrders(shopOrderDAO.getShopOrdersByUserId(id));
        return u;
    }

    public User createNewUser(User u) {
        uDAO.createEntity(u);
        return u;
    }

    public User updateUser(User u) {
        uDAO.updateEntity(u);
        return u;
    }

    public void deleteUser(User u) {
        uDAO.removeEntity(u);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = uDAO.getAllUsers();
        return allUsers;
    }
}
