package com.gua.mqtt.pro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 86188
 */
@Configuration
@Slf4j
public class MqttConfiguration {

    @Autowired
    private MqttValue mqttValue;

    @Bean("mqttPushClient")
    public MqttPushClient getMqttPushClient() {
        if (log.isInfoEnabled()) {
            log.info("===============>>>Mqtt is run starting:<<==================");
        }
        MqttPushClient mqttPushClient = new MqttPushClient();
        mqttPushClient.connect(mqttValue);
        // 订阅主题
        mqttPushClient.subscribe(mqttValue.getTopic(), mqttValue.getQos());
        return mqttPushClient;
    }


}