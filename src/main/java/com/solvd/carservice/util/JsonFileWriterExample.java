package com.solvd.carservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.carservice.enums.OrderStatus;
import com.solvd.carservice.model.ShopOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonFileWriterExample {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void parse() {
        List<ShopOrder> shopOrders = new ArrayList<>();
        shopOrders.add(new ShopOrder(1, 1, 1, 1, new Date(), OrderStatus.APPROVED));
        shopOrders.add(new ShopOrder(2, 2, 2, 2, new Date(), OrderStatus.CANCELLED));
        shopOrders.add(new ShopOrder(3, 3, 1, 3, new Date(), OrderStatus.DELIVERED));
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/resources/json/ShopOrderFromJava.json"), shopOrders);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }
}
