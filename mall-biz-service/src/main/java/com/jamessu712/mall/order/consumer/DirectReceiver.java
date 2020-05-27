package com.jamessu712.mall.order.consumer;

import com.jamessu712.mall.order.service.OrderService;
import com.jamessu712.mall.web.api.model.OrderModel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {

    @Autowired
    OrderService orderService;

        @RabbitHandler
        public void process(Map testMessage) {
            System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
            orderService.insertOrder((OrderModel) testMessage.get("orderModel"));
        }

}

