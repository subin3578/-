package com.ch05.controller;

import com.ch05.dto.User1DTO;
import com.ch05.dto.User2DTO;
import com.ch05.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private final User2Service user2Service;
    @Autowired
    public User2Controller(User2Service user2Service) {
        this.user2Service = user2Service;
    }

    @GetMapping("/user2/register")
    public String register() {
        return "user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto){

        user2Service.insertUser2(dto);

        return "redirect:/user2/list";
    }
    @GetMapping("/user2/list")
    public String list(Model model) {

        List<User2DTO> users = user2Service.selectUser2s();
        model.addAttribute("users", users);
        return "/user2/list";
    }
    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {

        User2DTO user = user2Service.selectUser2(uid);

        model.addAttribute(user);

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO dto) {
        user2Service.updateUser2(dto);
        return "redirect:/user2/list";
    }
    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid) {
        user2Service.deleteUser2(uid);
        return "redirect:/user2/list";
    }
}
