package com.gua.mqtt.sz;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    private String brokerUrl = "tcp://localhost:1883";
    private String clientId = "clientId";
    private String topic = "test/topic";

    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName("username");
        mqttConnectOptions.setPassword("password".toCharArray());
        return mqttConnectOptions;
    }

    @Bean
    public MqttClient getMqttClient() throws MqttException {
        MqttClient mqttClient = new MqttClient(brokerUrl, clientId);
        mqttClient.connect(getMqttConnectOptions());
        mqttClient.subscribe(topic);
        return mqttClient;
    }
}