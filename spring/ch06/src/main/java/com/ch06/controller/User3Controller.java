package com.ch06.controller;

import com.ch06.dto.User2DTO;
import com.ch06.dto.User3DTO;
import com.ch06.service.User3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class User3Controller {

    private final User3Service user3Service;

    @GetMapping("/user3/list")
    public String list(Model model) {
        List<User3DTO> users = user3Service.selectUser3s();
        model.addAttribute("users",users);
        return "/user3/list";
    }
}
