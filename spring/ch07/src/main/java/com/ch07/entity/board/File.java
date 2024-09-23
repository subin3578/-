package com.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity                 // 엔티티 객체 정의
@Table(name = "board_file")  // 매핑 테이블 설정
@Builder
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;

    private String oName;
    private String sName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ano")
    private Article article;

}
