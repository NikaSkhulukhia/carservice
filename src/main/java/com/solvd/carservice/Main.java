package com.solvd.carservice;

import com.solvd.carservice.model.User;
import com.solvd.carservice.service.UserService;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        UserService userv = new UserService();
        User testUser = userv.getUserById(1);
        System.out.println(testUser.toString());
    }
}