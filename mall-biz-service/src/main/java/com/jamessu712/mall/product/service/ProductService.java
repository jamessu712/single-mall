package com.jamessu712.mall.product.service;

import com.jamessu712.mall.product.mapper.ProductMapper;
import com.jamessu712.mall.product.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public ProductModel getProductByCode(String code) {
        log.info("查询Product【productCode】= {}", code);
        return productMapper.getProductByCode(code);
    }
}
