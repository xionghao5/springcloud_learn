package com.gua.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RmqConfig {

    @Bean
    public DefaultMQProducer getDefaultMQProducer() throws MQClientException {
        // 初始化一个producer并设置Producer group name
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name"); //（1）
        // 设置NameServer地址
        producer.setNamesrvAddr("192.168.91.131:9876");  //（2）
        // 启动producer
        producer.start();

        return producer;
    }
}
