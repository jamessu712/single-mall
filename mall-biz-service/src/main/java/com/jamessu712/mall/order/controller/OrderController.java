package com.jamessu712.mall.order.controller;

import com.jamessu712.mall.common.cache.redis.RedisUtil;
import com.jamessu712.mall.order.model.OrderModel;
import com.jamessu712.mall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author jamessu
 * @Date 20/05/2020 3:22 PM
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController{

    @Autowired
    OrderService orderService;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/{orderCode}", method = RequestMethod.GET)
    public OrderModel getOrderByCode(@PathVariable final String orderCode) {
        OrderModel orderModel = getCacheOrder(orderCode);
        if (null == orderModel) {
            orderModel = orderService.getOrderByCode(orderCode);
        }
        return orderModel;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public int createOrder() {
        OrderModel orderModel = new OrderModel();
        orderModel.setCode("00002");
        BigDecimal totalPrice = new BigDecimal(100);
        orderModel.setTotalPrice(totalPrice);
        int Result = orderService.insertOrder(orderModel);

        setCacheOrder(orderModel.getCode(), orderModel);
        return Result;
    }


    protected OrderModel getCacheOrder(String orderCode) {
        OrderModel orderModel = (OrderModel) redisUtil.getObject("order-" + orderCode);
        log.info("get order[" + orderCode + "] from redis");
        return orderModel;
    }

    protected void setCacheOrder(String orderCode, OrderModel orderModel) {
        redisUtil.setObject("order-" + orderModel.getCode(), orderModel);
        log.info("set order[" + orderCode + "] from redis");
    }

}
