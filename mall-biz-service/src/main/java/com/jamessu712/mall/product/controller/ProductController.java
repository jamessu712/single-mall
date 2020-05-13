package com.jamessu712.mall.product.controller;

import com.jamessu712.mall.product.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @RequestMapping(value = "/{productCode}", method = RequestMethod.GET)
    public ProductDTO getProductByCode(@PathVariable final String productCode) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("00001");
        productDTO.setName("huawei p30");
        return productDTO;
    }
}
