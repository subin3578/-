package com.ch09.entity;

import com.ch09.dto.User1DTO;
import com.ch09.dto.User2DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user2")
public class User2 {
    @Id
    private String uid;

    private String name;
    private String birth;
    private int age;
    private String addr;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .age(age)
                .addr(addr)
                .build();
    }

}
