package com.jamessu712.mall.order.service;

import com.jamessu712.mall.order.mapper.OrderMapper;
import com.jamessu712.mall.common.model.OrderModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author jamessu
 * @Date 20/05/2020 3:23 PM
 * @Version 1.0
 **/
@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public OrderModel getOrderByCode(String code) {
        log.info("查询Order【orderCode】= {}", code);
        return orderMapper.getOrderByCode(code);
    }

    public int insertOrder(OrderModel orderModel){
        log.info("创建订单行【orderCode】= {}",orderModel.getCode());
        orderMapper.insertOrder(orderModel);
        return 1;
    }

}
