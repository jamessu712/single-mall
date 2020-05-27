package com.jamessu712.mall.web.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 2862859549103958867L;
    private int pk;
    private Timestamp creationTime;
    private Timestamp modifiedTime;

    private String code;
    private BigDecimal totalPrice;

}
