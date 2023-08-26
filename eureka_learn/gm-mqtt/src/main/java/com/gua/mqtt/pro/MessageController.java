package com.gua.mqtt.pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqttpro")
public class MessageController {

    @Autowired
    MqttValue mqttValue;

    @Autowired
    private MqttSender mqttSender;

    @Autowired
    private MqttPushClient mqttPushClient;

    /***
     * 发布消息，用于其他客户端消息接收测试
     */
    @RequestMapping("/sendMqttMessage")
    public String sendMqttMessage(String topic) {
        String jsonStr = "{\"truckPic\":\"20201029111.jpg\",\"httpRootPic\":\"url\"}";
        mqttSender.send(topic, jsonStr);
        return "ok";
    }

    @RequestMapping("/mqttop")
    public String mqttop() {
        String TOPIC1 = "test_topic1";
        String TOPIC2 = "test_topic2";
        String TOPIC3 = "test_topic3";
        String TOPIC4 = "test_topic4";

        int Qos1 = 1;
        int Qos2 = 1;
        int Qos3 = 1;
        int Qos4 = 1;

        String[] topics = { TOPIC1, TOPIC2, TOPIC3, TOPIC4 };
        int[] qos = { Qos1, Qos2, Qos3, Qos4 };
        mqttPushClient.subscribe(topics, qos);
        return "订阅主题";
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

}
