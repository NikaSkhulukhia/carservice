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
}
