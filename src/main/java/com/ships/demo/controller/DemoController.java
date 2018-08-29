package com.ships.demo.controller;
import com.ships.demo.ShipJSONProcessor;
import com.ships.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DemoController {
    @Autowired
    GameService gameService;
    @RequestMapping(value="/login")
    @ResponseBody
    public String login(@RequestParam("data") String data) {
        final Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("\n" + data);
        return "Login";
    }
    @RequestMapping(value="/test")
    @ResponseBody
    public String test(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        return param1 + param2;
    }
    @RequestMapping(value="/testboard")
    @ResponseBody
    public String testboard(@RequestParam("board_size") int boardSize, @RequestParam("ships_num") int shipsNum, @RequestParam("smallest_ship_size") int smallestShipSize) {
        String resp = gameService.testBoard(boardSize, shipsNum, smallestShipSize);
        return "<pre>" + resp  + "</pre>";
    }
    @RequestMapping(value="/testjson")
    @ResponseBody
    public String testJSON() {
        ShipJSONProcessor shipJSONProcessor = new ShipJSONProcessor();
        try {
            shipJSONProcessor.readJSONfromFile();
        } catch (Exception e) {
            return "Exception while testing JSON</br>" + e.toString();
        }
        return "testing JSON";
    }
}
