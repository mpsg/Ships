package com.ships.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;

public class ShipJSONProcessor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public PositionedShip readJSONfromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        PositionedShip ship = objectMapper.readValue(new File("C:\\Users\\Paweł\\Desktop\\Ships\\src\\main\\java\\com\\ships\\demo\\ship.json"), PositionedShip.class);
        logger.info(ship.toString());
        String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ship);
        logger.info("Ship in JSON is\n" + jsonInString);
        return ship;
    }

}
