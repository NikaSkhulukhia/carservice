package com.solvd.carservice;

import com.solvd.carservice.model.CarPart;
import com.solvd.carservice.model.User;
import com.solvd.carservice.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;
import java.util.List;

import static com.solvd.carservice.util.CarPartsXMLParser.parseCarParts;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.trace("START");

        // test user service and getUserById method
        UserService userService = new UserService();
        User testUser = userService.getUserById(1);
        LOGGER.trace("user: " + testUser.toString());

        // STAX xml parser for car part objects
        LOGGER.trace("Parse xml using STAX");
        List<CarPart> carParts = parseCarParts("src/main/resources/xml/CarParts.xml");
        for (CarPart carPart : carParts) {
            LOGGER.trace(carPart.getId() + " " + carPart.getName() + " " + carPart.getSerialNumber());
        }
        LOGGER.trace("Parse done using STAX");

        // JAXB xml parser for user objects
        // Creating the JAXB context
        LOGGER.trace("Parse xml using JAXB");
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(User.class);
            // Marshaller - The process of converting a Java object to an XML document.
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File xmlFile = new File("src/main/resources/xml/user.xml");
            marshaller.marshal(testUser, xmlFile);
            // Unmarshaller - The process of converting an XML document to a Java object.
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            User testUser2 = (User) unmarshaller.unmarshal(xmlFile);
            LOGGER.trace("user from jaxb unmarshall: " + testUser2.toString());
        } catch (JAXBException e) {
            LOGGER.info(e);
        }
        LOGGER.trace("Parse done using JAXB");

        // Test user service methods
        LOGGER.trace("Test createEntity");
        User testUser3 = new User();
        testUser3.setFirstName("Bob");
        testUser3.setLastName("Bean");
        testUser3.setAddress("222 Lime St.");
        testUser3.setEmail("Bob.Bean@example.com");
        testUser3.setIdNumber("139579498");
        testUser3.setPhone("444-555-23456");
        testUser3.setMemberSince(new java.sql.Date(new java.util.Date().getTime()));
        testUser3 = userService.createNewUser(testUser3);
        LOGGER.trace("testUser3 auto generated id = " + testUser3.getId());
        LOGGER.trace("End Test createEntity");

        // END main
        LOGGER.trace("END");
    }
}