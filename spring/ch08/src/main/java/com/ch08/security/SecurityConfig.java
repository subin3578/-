package com.ch08.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    /*
        스프링 시큐리티
        - Spring 프레임워크에서 제공하는 보안관련 처리를 위한 프레임워크
        - Spring 기반 프로젝트는 Sprint Security로 보안(인증. 인가)처리 권자

        인증 설정
        - 로그인, 로그아웃 페이지 및 요청주소 사용자 설정
        - 기존 인증(로그인, 로그아웃)은 Security가 제공하는 기본 인증 페이지
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        // 로그인 설정
        http.formLogin(login -> login
                .loginPage("/user/login")
                .defaultSuccessUrl("/user/success")
                .failureUrl("/user/login?success=100")
                .usernameParameter("uid")
                .passwordParameter("pass"));

        // 로그아웃 설정
        http.logout(logout -> logout
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login?success=101"));
        // 인가 설정
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/staff/**").hasAnyRole("ADMIN", "MANAGER", "STAFF")
                .anyRequest().permitAll());

        // 기타 보안 설정
        http.csrf(configure -> configure.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}