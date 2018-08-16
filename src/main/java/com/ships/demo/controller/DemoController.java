package com.ships.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @RequestMapping(value="/login")
    @ResponseBody
    public String login() {
        return "Login";
    }
}
