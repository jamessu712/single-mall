package com.jamessu712.mall.product.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {

    private int pk;
    private long creationTime;
    private long modifiedTime;

    private String code;
    private String name;
    private String description;
}
