package com.solvd.carservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.carservice.model.ShopOrder;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ShopOrdersJSONParser {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void parseShopOrdersJSON() throws IOException {
        String json = FileUtils.readFileToString(new File("src/main/resources/json/ShopOrderForParse.json"), "UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        List<ShopOrder> shopOrders = mapper.readValue(json, new TypeReference<List<ShopOrder>>(){});
        for (ShopOrder shopOrder : shopOrders) {
            LOGGER.trace(shopOrder.toString());
        }
    }
}
