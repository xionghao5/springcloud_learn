package com.gua.mqtt.pro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mqttbean {

    @Bean("mqttPushClient")
    public MqttPushClient getMqttPushClient() {
        MqttPushClient mqttPushClient = new MqttPushClient();
        return mqttPushClient;
    }

}