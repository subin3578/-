package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.repository.User1Repository;
import com.ch09.service.User1Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody // 이걸 생략하면 swagger-ui/index.html에서 안보임
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> users = user1Service.selectUser1s();

        return users;



    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){
        User1DTO user = user1Service.selectUser1(uid);
        return user;
    }

    @ResponseBody
    @PostMapping("/user1")
    public ResponseEntity register(@RequestBody User1DTO user1DTO){
        log.info(user1DTO);
        User1 savedUser1 = user1Service.insertUser1(user1DTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser1);
    }

    @ResponseBody
    @PutMapping("/user1")
    public ResponseEntity modify(@RequestBody User1DTO user1DTO){
        User1 modifiedUser1 = user1Service.updateUser1(user1DTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(modifiedUser1);

    }
    @ResponseBody
    @DeleteMapping("/user1/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid) {

        try{
            user1Service.deleteUser1(uid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(uid);
        }catch(EntityNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
