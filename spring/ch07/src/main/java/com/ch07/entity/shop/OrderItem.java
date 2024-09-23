package com.ch07.entity.shop;


import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity                 // 엔티티 객체 정의
@Table(name = "shop_orderitem")  // 매핑 테이블 설정
@Builder
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderNo")
    private Order order;

    @OneToOne
    private Product product;

    private int count;
}
