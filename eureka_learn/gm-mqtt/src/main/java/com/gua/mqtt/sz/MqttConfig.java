//package com.gua.mqtt.sz;
//
//
//import org.eclipse.paho.client.mqttv3.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//@Configuration
//public class MqttConfig {
//
//
//    private String username = "admin";
//    private String password = "password";
//
//    private String brokerUrl = "tcp://broker.emqx.io:1883";
//    private String clientId = "pubClient";
//    private String topic = "test/topic";
//
//    @Bean
//    public MqttConnectOptions getMqttConnectOptions() {
//        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
//        mqttConnectOptions.setUserName(username);
//        mqttConnectOptions.setPassword(password.toCharArray());
//        return mqttConnectOptions;
//    }
//
//
//    @Bean
//    public MqttCallback getMqttCallback(){
//        MqttCallback mqttCallback =new MqttCallback() {
//
//            @Override
//            public void connectionLost(Throwable cause) {
//                // 处理连接断开的情况
//                System.out.println("连接断开: " + cause.toString());
//            }
//
//            @Override
//            public void messageArrived(String topic, MqttMessage message) throws Exception {
//                // 处理收到的消息
//                System.out.println("topic:" + topic);
//                System.out.println("消息体: " + message.toString());
//                System.out.println("消息: " + new String(message.getPayload()));
//            }
//
//            @Override
//            public void deliveryComplete(IMqttDeliveryToken token) {
//                // 处理消息发送完成的情况
//                System.out.println("消息处理完成: " + token.toString());
//            }
//        };
//
//        return mqttCallback;
//    }
//
//    @Bean
//    public MqttClient getMqttClient(MqttCallback mqttCallback) throws MqttException {
//        MqttClient mqttClient = new MqttClient(brokerUrl, clientId);
//        mqttClient.connect(getMqttConnectOptions());
//        mqttClient.subscribe(topic);
//        mqttClient.setCallback(mqttCallback);
//        return mqttClient;
//    }
//}