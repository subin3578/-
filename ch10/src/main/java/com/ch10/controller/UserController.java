package com.ch10.controller;

import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.jwt.JwtProvider;
import com.ch10.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.Jar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final  JwtProvider jwtProvider;
    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO){
       log.info("login1 -"+userDTO);

       // Spring Security 인증 처리
        UsernamePasswordAuthenticationToken authToken
                = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getPass());

        Authentication authentication = authenticationManager.authenticate(authToken);
        log.info("login2 - "+authentication);

        try{
            // 인증된 사용자 객체 가져오기
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            log.info("login3 - "+ myUserDetails);

            User user = myUserDetails.getUser();
            log.info("login4 -" +user);

            // 토큰 생성
            String accessToken = jwtProvider.createToken(user,1);
            String refreshToken = jwtProvider.createToken(user,7);
            log.info("login5 - "+accessToken);

            // Refresh 토큰 DB 저장

            // Access, Refresh 토큰 전송
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("accessToken", accessToken);
            resultMap.put("refreshToken", refreshToken);

            return ResponseEntity
                    .ok()
                    .body(resultMap);
        } catch(Exception e){
            // 인증 실패

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User Not Found");
        }

    }
}
