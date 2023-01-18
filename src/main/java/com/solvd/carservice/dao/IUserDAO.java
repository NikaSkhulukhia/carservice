package com.solvd.carservice.dao;

import com.solvd.carservice.model.User;

import java.util.List;

public interface IUserDAO extends IBaseDAO{
    List<User> getAllUsers();
}
