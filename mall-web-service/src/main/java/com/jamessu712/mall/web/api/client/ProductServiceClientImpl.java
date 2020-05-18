package com.jamessu712.mall.web.api.client;

import com.jamessu712.mall.common.api.BaseResponse;
import com.jamessu712.mall.web.api.dto.GenericProductResponse;
import com.jamessu712.mall.web.api.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class ProductServiceClientImpl implements ProductServiceClient {

    private final WebClient.Builder webClientBuilder;

//    private final String application_name = "biz-service";
    private final String application_name = "localhost:8081";

    @Override
    public Mono<ProductDTO> getProductByCode(String productCode) {
        return webClientBuilder.build().get()
                .uri("http://" + application_name + "/products/{productCode}", productCode)
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }
}


