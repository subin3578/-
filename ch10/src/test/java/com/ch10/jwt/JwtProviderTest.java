
package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;


    @Test
    void createToken() {

        User user = User.builder()
                .uid("a101")
                .name("김유신")
                .birth("1990-09-09")
                .role("ADMIN")
                .build();

        String jwt = jwtProvider.createToken(user, 1);
        System.out.println(jwt);
    }

    @Test
    void getClaims() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGhhazA1MDNAZ21haWwuY29tIiwiaWF0IjoxNzI2MTIyOTAyLCJleHAiOjE3MjYyMDkzMDIsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.HWTle6NXO3xi28MfwQ5Pg5v5fzKE1LUfJOeqbyZ5At0";

        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + ", " + role);
    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGhhazA1MDNAZ21haWwuY29tIiwiaWF0IjoxNzI2MTIzNzQxLCJleHAiOjE3MjYxMjM3NDEsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.yH3PS1IGrC1mn0Qztmij53SsA7xRRRczfLrkTg0xg9c";

        try {
            jwtProvider.validateToken(token);
            System.out.println("토큰 이상 없음");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
