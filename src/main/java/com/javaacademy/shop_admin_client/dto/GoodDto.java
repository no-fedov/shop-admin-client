package com.javaacademy.shop_admin_client.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodDto {
    private String name;
    private BigDecimal price;
}
