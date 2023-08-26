package com.gua.mqtt.pro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 86188
 */
@Service
@Slf4j
public class MqttServiceImpl implements MqttService {

    @Autowired
    MqttValue mqttValue;

    @Autowired
    private MqttSender mqttSender;


    @Override
    public void sendMessage() {
        String jsonStr = null;
        mqttSender.send(mqttValue.getTopic()[0], jsonStr);

    }

    @Override
    public void messageArrived(String mqttResponseBody) {
        log.info("接口的消息：{}", mqttResponseBody);
        // todo 数据服务保存数据
    }

    @Override
    public void messageHeartbeat(String mqttResponseHeartbeat) {
        log.info("监听心跳信息：{}", mqttResponseHeartbeat);
        // todo 数据服务处理心跳
    }

}
