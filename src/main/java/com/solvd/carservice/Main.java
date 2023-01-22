package com.solvd.carservice;

import com.solvd.carservice.model.CarPart;
import com.solvd.carservice.model.User;
import com.solvd.carservice.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.carservice.util.CarPartsXMLParser.parseCarParts;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args)
    {
        LOGGER.info("START");

        // test user service and getUserById method
        UserService userv = new UserService();
        User testUser = userv.getUserById(1);
        LOGGER.info("user: " + testUser.toString());

        // STAX xml parser for car part objects
        LOGGER.info("Parse xml using STAX");
        List<CarPart> carParts = parseCarParts("src/main/resources/xml/CarParts.xml");
        for (CarPart carPart : carParts) {
            System.out.println(carPart.getId() + " " + carPart.getName() + " " + carPart.getSerialNumber());
        }
        LOGGER.info("Parse done");

        LOGGER.info("END");
    }
}