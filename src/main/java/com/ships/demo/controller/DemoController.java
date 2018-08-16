package com.ships.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @RequestMapping(value="/login")
    @ResponseBody
    public String login() {
        return "Login";
    }
    @RequestMapping(value="/test")
    @ResponseBody
    public String test(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        return Integer.toString(Integer.parseInt(param1) + Integer.parseInt(param2));
    }
}
