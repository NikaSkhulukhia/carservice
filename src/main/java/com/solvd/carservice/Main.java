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
import java.util.List;

import static com.solvd.carservice.util.CarPartsXMLParser.parseCarParts;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
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
        LOGGER.info("Parse done using STAX");

        // JAXB xml parser for user objects
        // Creating the JAXB context
        LOGGER.info("Parse xml using JAXB");
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
            User user = (User) unmarshaller.unmarshal(xmlFile);
            LOGGER.info("user from jaxb unmarshall: " + user.toString());
        } catch (JAXBException e) {
            LOGGER.info(e);
        }
        LOGGER.info("Parse done using JAXB");

        // END main
        LOGGER.info("END");
    }
}