package com.ch06.controller;

import com.ch06.dto.User1DTO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

// private Logger logger = LoggerFactory.getLogger(this.getclass()); 이 방법 사용 안해도 됨
@Log4j2
@Controller
public class MainController {

    @GetMapping(value = {"/","index"})
    public String index(Model model) {

        String str1 = "Hello World!";
        String str2 = "Hello Spring Boot!";

        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);

        // DTO 생성 - 생성자 초기화
        User1DTO user1 = new User1DTO("A101","김유신","1990-01-01","010-1234-1000",21);
        log.info(user1);

        // DTO 생성 - 세터 초기화
        User1DTO user2 = new User1DTO();
        user2.setUid("A102");
        user2.setName("강감찬");
        user2.setBirth("1990-10-24");
        user2.setHp("010-1234-1001");
        user2.setAge(22);
        log.info(user2);

        // DTO 생성 - 빌더 초기화
        User1DTO user3 = User1DTO.builder()
                .uid("a103")
                .name("장보고")
                .birth("1999-10-14")
                .hp("010-4324-1442")
                .age(23)
                .build();
        log.info(user3);

        model.addAttribute("user1",user1);
        model.addAttribute("user2",user2);
        model.addAttribute("user3",user3);

        List<User1DTO> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        model.addAttribute("users",users);

        return "index";
    }


}
