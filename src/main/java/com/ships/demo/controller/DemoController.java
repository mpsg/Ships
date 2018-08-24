package com.ships.demo.controller;
import com.ships.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @Autowired
    GameService gameService;
    @RequestMapping(value="/login")
    @ResponseBody
    public String login() {
        return "Login";
    }
    @RequestMapping(value="/testboard")
    @ResponseBody
    public String testboard(@RequestParam("board_size") int boardSize, @RequestParam("ships_num") int shipsNum, @RequestParam("smallest_ship_size") int smallestShipSize) {
        String resp = gameService.testBoard(boardSize, shipsNum, smallestShipSize);
        return "<pre>" + resp  + "</pre>";
    }
}
