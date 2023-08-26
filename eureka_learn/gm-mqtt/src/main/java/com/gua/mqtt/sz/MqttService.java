package com.gua.mqtt.sz;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    private MqttClient mqttClient;

    @Autowired
    public MqttService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void sendMessage(String message) {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        try {
            mqttClient.publish("test/topic", mqttMessage);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}
