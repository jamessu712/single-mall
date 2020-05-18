package com.jamessu712.mall.web.api.client;

import com.jamessu712.mall.common.api.BaseResponse;
import com.jamessu712.mall.web.api.dto.GenericProductResponse;
import com.jamessu712.mall.web.api.dto.ProductDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

//@FeignClient(name = "biz-service", path = "/products", url = "http://localhost:8081")
public interface ProductServiceClient {

    @GetMapping(path = "/{productCode}")
    Mono<ProductDTO> getProductByCode(@PathVariable final String productCode);
}
