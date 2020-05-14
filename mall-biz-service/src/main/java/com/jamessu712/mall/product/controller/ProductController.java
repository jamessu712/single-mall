package com.jamessu712.mall.product.controller;

import com.jamessu712.mall.product.dto.ProductDTO;
import com.jamessu712.mall.product.model.ProductModel;
import com.jamessu712.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/{productCode}", method = RequestMethod.GET)
    public ProductModel getProductByCode(@PathVariable final String productCode) {
        ProductModel productModel = productService.getProductByCode(productCode);
        return productModel;

//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setCode("00001");
//        productDTO.setName("huawei p30");
//        return productDTO;
    }
}
