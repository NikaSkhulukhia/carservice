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
        LOGGER.trace("START");

        // test user service and getUserById method
        UserService userv = new UserService();
        User testUser = userv.getUserById(1);
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
            User user = (User) unmarshaller.unmarshal(xmlFile);
            LOGGER.trace("user from jaxb unmarshall: " + user.toString());
        } catch (JAXBException e) {
            LOGGER.info(e);
        }
        LOGGER.trace("Parse done using JAXB");

        // END main
        LOGGER.trace("END");
    }
}