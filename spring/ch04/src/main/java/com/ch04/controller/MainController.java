package com.ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

                    // value 랑 method
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello...");
        return "hello";
    }

    @GetMapping("/welcome")
    public void welcome(){
        System.out.println("welcome...");
    }
    @GetMapping("/greeting")
    public void greeting(){
        System.out.println("greeting...");
    }
}
