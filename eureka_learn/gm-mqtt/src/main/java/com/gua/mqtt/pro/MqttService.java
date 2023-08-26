package com.gua.mqtt.pro;

public interface MqttService {

    /**
     * @Title: sendMessage
     * @Description: 发送消息

     */
    void sendMessage();

    /**
     * @Title: messageArrived
     * @Description: 监听发送消息

     * @param mqttResponseBody
     */
    void messageArrived(String mqttResponseBody);

    /**
     * @Title: messageHeartbeat
     * @Description: 设备心跳监听
     * @Author youli
     * @date 2021年7月4日
     * @param mqttResponseHeartbeat
     */
    void messageHeartbeat(String mqttResponseHeartbeat);
}
