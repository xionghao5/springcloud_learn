package com.gua.consume;

import com.gua.pojo.CartItemEvent;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "cart-item-add-topic",
        consumerGroup = "cart-consumer_cart-item-add-topic"
)
public class CardItemAddConsumer implements RocketMQListener<CartItemEvent> {
    public void onMessage(CartItemEvent addItemEvent) {
        System.out.println("Adding item: {}" + addItemEvent);
        // additional logic
    }
}
