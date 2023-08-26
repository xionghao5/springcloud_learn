package com.gua.mqtt.pro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MqttApplicationRunner implements ApplicationRunner {

    @Autowired
    private MqttConfig mqttConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (log.isInfoEnabled()) {
            log.info("===============>>>Mqtt is run starting:<<==================");
        }
        MqttPushClient mqttPushClient = new MqttPushClient();
        mqttPushClient.connect(mqttConfig);
        // 订阅主题
        mqttPushClient.subscribe(mqttConfig.getTopic(), mqttConfig.getQos());
    }

}
