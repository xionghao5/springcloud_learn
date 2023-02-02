package com.gua.product;

import com.gua.pojo.CartItemEvent;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class EventProducer implements CommandLineRunner {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... strings) throws Exception {

        rocketMQTemplate.convertAndSend("cart-item-add-topic", new CartItemEvent("bike", 1));
        rocketMQTemplate.convertAndSend("cart-item-add-topic", new CartItemEvent("computer", 2));
        rocketMQTemplate.convertAndSend("cart-item-removed-topic", new CartItemEvent("bike", 1));

    }
}
