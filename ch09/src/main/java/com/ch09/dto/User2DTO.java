package com.ch09.dto;

import com.ch09.entity.User1;
import com.ch09.entity.User2;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {
    private String uid;
    private String name;
    private String birth;
    private int age;
    private String addr;

    public User2 toEntity(){
        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .age(age)
                .addr(addr)
                .build();
    }

}
