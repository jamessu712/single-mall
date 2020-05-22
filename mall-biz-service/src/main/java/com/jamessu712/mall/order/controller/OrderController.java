package com.jamessu712.mall.order.controller;

import com.jamessu712.mall.order.model.OrderModel;
import com.jamessu712.mall.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author jamessu
 * @Date 20/05/2020 3:22 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/orders")
public class OrderController{

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/{orderCode}", method = RequestMethod.GET)
    public OrderModel getOrderByCode(@PathVariable final String orderCode) {
        OrderModel orderModel = orderService.getOrderByCode(orderCode);
        return orderModel;
    }


}
