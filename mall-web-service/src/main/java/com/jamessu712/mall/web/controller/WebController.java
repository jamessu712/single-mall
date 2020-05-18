package com.jamessu712.mall.web.controller;


import com.jamessu712.mall.common.api.BaseResponse;
import com.jamessu712.mall.web.api.client.ProductServiceClient;
import com.jamessu712.mall.web.api.dto.GenericProductResponse;
import com.jamessu712.mall.web.api.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/web")
public class WebController {

    private final ProductServiceClient productServiceClient;


    @RequestMapping(value = "/products/{productCode}", method = RequestMethod.GET)
    public Mono<ProductDTO> getProductByCode(@PathVariable final String productCode) {

        Mono<ProductDTO> resp = productServiceClient.getProductByCode(productCode);
        return resp;
    }
}
