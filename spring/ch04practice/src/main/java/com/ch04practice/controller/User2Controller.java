package com.ch04practice.controller;

import com.ch04practice.dto.User2DTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class User2Controller {

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){

        return "redirect:/user2/list";
    }
    @GetMapping("/user2/list")
    public String list(){
        return "/user2/list";
    }
    @GetMapping("/user2/modify")
    public String modify(){
        return "/user2/modify";
    }
    @GetMapping
    public String delete(){
        return "redirect:/user2/list";
    }

}
