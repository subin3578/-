package com.ch04.controller;

import com.ch04.dto.User1DTO;
import com.ch04.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class user1Controller {

    // 생성자 주입
    private User1Service service;
    @Autowired
    public void setService(User1Service service) {
        this.service = service;
    }

    // register
    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO dto){
        System.out.println(dto);

        //등록
        service.insertUser1(dto);

        //리다이렉트
        return "redirect:/user1/list";
    }

    // list
    @GetMapping("/user1/list")
    public String list(Model model){

        // 조회
        List<User1DTO> users = service.selectUser1s();
        System.out.println(users);

        // req.setAttribute(users);
        // 모델 참조
        model.addAttribute("users",users);
        return "/user1/list";
    }

    // modify
    @GetMapping("/user1/modify") // @ 어노테이션 생략될 수 있음 //
    public String modify(@RequestParam("uid") String uid, Model model){

        System.out.println("uid = " + uid);

        // 수정 회원 조회
        User1DTO user = service.selectUser1(uid);

        //모델 참조
        model.addAttribute(user);
        // (KEY, VALUE) KEY 생략 시 타입명으로 저장 (소문자 시작) => user1DTO

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO dto){
        System.out.println(dto);

        service.updateUser1(dto);
        // @ModelAttribute 와 model.addAttribute(dto); 는 생략 가능

        return "redirect:/user1/list";
    }

    // delete
    @GetMapping("/user1/delete") // @RequestParam은 생략 불가능
    public String delete(@RequestParam("uid") String uid){
        //public String delete(User1DTO user){
        // service.deleteUser1(User1DTO.getUid());
        // } 사용 가능
        service.deleteUser1(uid);
        return "redirect:/user1/list";
    }
}
