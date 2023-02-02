package com.gua.consume;

import com.gua.pojo.CartItemEvent;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "cart-item-removed-topic",
        consumerGroup = "cart-consumer_cart-item-removed-topic"
)
public class CardItemRemoveConsumer implements RocketMQListener<CartItemEvent> {
    public void onMessage(CartItemEvent removeItemEvent) {
        System.out.println("Removing item: {}" + removeItemEvent);
        // additional logic
    }
}