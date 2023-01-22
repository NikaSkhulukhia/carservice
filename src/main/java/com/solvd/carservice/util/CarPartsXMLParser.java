package com.solvd.carservice.util;

import com.solvd.carservice.model.CarPart;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

// parse car parts xml data using stax
public class CarPartsXMLParser {

    public static List<CarPart> parseCarParts(String filePath) {
        List<CarPart> carParts = new ArrayList<>();
        CarPart carPart = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filePath));
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("CarPart")) {
                            carPart = new CarPart();
                        }
                        if (reader.getLocalName().equals("id")) {
                            carPart.setId(Long.parseLong(reader.getElementText()));
                        }
                        if (reader.getLocalName().equals("name")) {
                            carPart.setName(reader.getElementText());
                        }
                        if (reader.getLocalName().equals("serialNumber")) {
                            carPart.setSerialNumber(reader.getElementText());
                        }
                        if (reader.getLocalName().equals("price")) {
                            carPart.setPrice(new BigDecimal(reader.getElementText()));
                        }
                        if (reader.getLocalName().equals("carPartCategoryId")) {
                            carPart.setCarPartCategoryId(Long.parseLong(reader.getElementText()));
                        }
                        if (reader.getLocalName().equals("shopId")) {
                            carPart.setShopId(Long.parseLong(reader.getElementText()));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("CarPart")) {
                            carParts.add(carPart);
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carParts;
    }
}

//    public static void main(String[] args) {
//        List<CarPart> carParts = parseCarParts("CarParts.xml");
//        for (CarPart carPart : carParts) {
//            System.out.println(carPart.getId() + " " + carPart.getName() + " " + carPart.getSerialNumber());
//            // or use the carPart object for other purposes
//        }
