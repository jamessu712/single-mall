package com.jamessu712.mall.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel {

    private int pk;
    private Timestamp creationTime;
    private Timestamp modifiedTime;

    private String code;
    private BigDecimal totalPrice;
}
