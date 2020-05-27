package com.jamessu712.mall.order.controller;

import com.jamessu712.mall.common.cache.redis.RedisUtil;
import com.jamessu712.mall.order.model.OrderModel;
import com.jamessu712.mall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static int numKey = 0;
    AtomicInteger i = new AtomicInteger();

    @RequestMapping(value = "/{orderCode}", method = RequestMethod.GET)
    public OrderModel getOrderByCode(@PathVariable final String orderCode) {
        //OrderModel orderModel = getCacheOrder(orderCode);
        OrderModel orderModel =  getCacheOrderByHashMap(orderCode,orderCode);
        /*if (null == orderModel) {
            orderModel = orderService.getOrderByCode(orderCode);
        }*/
        return orderModel;
    }

    @RequestMapping(value = "/createOrderByMapKey", method = RequestMethod.GET)
    public synchronized int createOrder() {
        OrderModel orderModel = new OrderModel();
        addI(orderModel);
        int Result = 0;
        BigDecimal totalPrice = new BigDecimal(100);
        orderModel.setTotalPrice(totalPrice);
        Map<String,Object> map = new HashMap<>();
        map.put("code",orderModel.getCode());
        map.put("price",orderModel.getTotalPrice());
        map.put("orderModel",orderModel);
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

    @RequestMapping(value = "/createOrderByKey", method = RequestMethod.GET)
    public int createOrderByKey() {
        OrderModel orderModel = new OrderModel();
        int code = numKey++;
        orderModel.setCode("0000" + code);

        BigDecimal totalPrice = new BigDecimal(100);
        orderModel.setTotalPrice(totalPrice);
       /* Map<String,Object> map = new HashMap<>();
        map.put("code",orderModel.getCode());
        map.put("price",orderModel.getTotalPrice());*/
        //int Result = orderService.insertOrder(orderModel);
        int Result = 0;
        //log.info(orderModel.getPk()+" toRedis");
        Long StartTime = System.currentTimeMillis();
        setCacheOrder(orderModel.getCode(), orderModel);
        Long EndTime = System.currentTimeMillis();
        log.info("the Insert RedisByKey Time: "+((EndTime-StartTime)/1000) + "s");
        //getCacheOrder(orderModel.getCode());
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

    protected void setCacheOrderByHashMap(String code , Map<String,Object> map){
        redisUtil.setObjectForHash(code,map);
        log.info("set order["+ code +"] by HashMap from redis");
    }

    protected OrderModel getCacheOrderByHashMap(String code , String mapKey){
        OrderModel orderModel = (OrderModel) redisUtil.getObjectForHash(code,mapKey);
        log.info("get order[" + code + "] from redis");
        return orderModel;
    }

    public synchronized void addI(OrderModel orderModel){
        i.incrementAndGet();
        orderModel.setCode("0000" + i);
    }
}
