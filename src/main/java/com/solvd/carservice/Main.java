package com.solvd.carservice;

import com.solvd.carservice.model.User;
import com.solvd.carservice.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args)
    {
        LOGGER.info("START");
        UserService userv = new UserService();
        User testUser = userv.getUserById(1);
        LOGGER.info("user: " + testUser.toString());
    }
}