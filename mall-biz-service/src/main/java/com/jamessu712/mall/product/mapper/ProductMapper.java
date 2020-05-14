package com.jamessu712.mall.product.mapper;


import com.jamessu712.mall.product.model.ProductModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    ProductModel getProductByCode(String code);
}
