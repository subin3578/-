package com.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity                 // 엔티티 객체 정의
@Table(name = "board_comment")  // 매핑 테이블 설정
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI Auto Increment
    private int no;

    private String content;

    @ManyToOne
    @JoinColumn(name="writer")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent")
    private Article article;

    @CreationTimestamp
    private LocalDateTime rdate;


}
