package com.ch10.security;



import com.ch10.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class MyUserDetails implements UserDetails {

    // User Entity 선언
    private User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 계정이 갖는 권한 목록을 생성하는 메서드
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole())); // 계정권한 앞에 접두어 ROLE_
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return user.getUid();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부 (ex 휴먼 계정)
        return true; // true: 만료안됨, false: 만료
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠김 여부 (ex 3회 이상 비밀번호 오류 시 로그인 제한)
        return true; // true: 잠김아님, false: 잠금
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호 만료 여부 (ex 6개월 경과 후 비밀번호 교체)
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정 활성화 여부(ex 탈퇴회원 비활성화)
            return true; // true:활성화, false: 비활성화
    }
}
