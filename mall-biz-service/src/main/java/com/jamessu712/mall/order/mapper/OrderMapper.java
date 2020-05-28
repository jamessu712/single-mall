package com.jamessu712.mall.order.mapper;


import com.jamessu712.mall.common.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author jamessu
 * @Date 20/05/2020 3:22 PM
 * @Version 1.0
 **/
@Mapper
public interface OrderMapper{

    OrderModel getOrderByCode(String code);

    int  insertOrder(OrderModel orderModel);
}
