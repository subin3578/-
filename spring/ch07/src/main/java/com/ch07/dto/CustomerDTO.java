package com.ch07.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String custId;
    private String name;
    private String address;
    private String hp;
    private String addr;
    private String regDate;

    //추가필드
    private long orderCount;
}
