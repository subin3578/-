package com.ch07.dto;

import lombok.Data;


// 프로덕트 집계 내기 위해 DTO 생성
@Data
public class ProductAggDTO {
    private int priceSum;
    private double priceAvg;
    private int priceMax;
    private int priceMin;

}
