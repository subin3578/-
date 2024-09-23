package com.jboard.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

        private int no;
        private String cate;
        private String title;
        private String content;
        private int comment;
        private int file;
        private int hit;
        private String writer;
        private String regip;
        private String rdate;

        // 추가 필드
        private String nick;
        private List<FileDTO> files;


    }
