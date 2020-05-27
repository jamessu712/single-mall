package com.jamessu712.mall.web.controller;


import com.jamessu712.mall.common.cache.redis.RedisUtil;


import com.jamessu712.mall.web.api.client.ProductServiceClient;
import com.jamessu712.mall.web.api.dto.ProductDTO;
import com.jamessu712.mall.web.api.model.OrderModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/web")
public class WebController {

    private final ProductServiceClient productServiceClient;


    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RabbitTemplate rabbitTemplate;

    AtomicInteger i = new AtomicInteger();

    @RequestMapping(value = "/products/{productCode}", method = RequestMethod.GET)
    public Mono<ProductDTO> getProductByCode(@PathVariable final String productCode) {

        Mono<ProductDTO> resp = productServiceClient.getProductByCode(productCode);
        return resp;
    }

    @RequestMapping(value = "/createOrders", method = RequestMethod.GET)
    public synchronized int createOrders() {
        OrderModel orderModel = new OrderModel();
        addI(orderModel);

        BigDecimal totalPrice = new BigDecimal(100);
        orderModel.setTotalPrice(totalPrice);
        Map<String,Object> map = new HashMap<>();
        map.put("code",orderModel.getCode());
        map.put("price",orderModel.getTotalPrice());
        map.put("orderModel",orderModel);
        int Result = 0;
        //log.info(orderModel.getPk()+" toRedis");
        Long StartTime = System.currentTimeMillis();
        //setCacheOrderByHashMap(orderModel.getCode(),map);
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        Long EndTime = System.currentTimeMillis();
        log.info("the Insert RedisByMapKey Time: "+((EndTime-StartTime)) + "ms");
        //setCacheOrder(orderModel.getPk(), orderModel);
        //getCacheOrder(orderModel.getCode());
        return Result;
    }

    public synchronized void addI(OrderModel orderModel){
        i.incrementAndGet();
        orderModel.setCode("0000" + i);
    }
}
