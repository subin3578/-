package com.ch09.entity;

import com.ch09.dto.User1DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user1")
public class User1 {

    @Id
    private String uid;

    private String name;
    private String birth;
    private int age;
    private String addr;

    private String email;

    public User1DTO toDTO(){
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .age(age)
                .addr(addr)
                .build();
    }

}
