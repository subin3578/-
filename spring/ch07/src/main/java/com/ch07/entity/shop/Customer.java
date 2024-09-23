package com.ch07.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity                 // 엔티티 객체 정의
@Table(name = "shop_customer")  // 매핑 테이블 설정
@Builder
@ToString
public class Customer {
    @Id
    private String custId;
    private int age;
    private String name;
    private String hp;
    private String addr;

    @CreationTimestamp
    private LocalDateTime rdate;
}
