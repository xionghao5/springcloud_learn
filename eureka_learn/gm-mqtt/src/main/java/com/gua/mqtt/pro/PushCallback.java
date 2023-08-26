package com.gua.mqtt.pro;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class PushCallback<component> implements MqttCallback {

    private MqttPushClient client;

    private MqttConfig mqttConfiguration;

    @Resource
    MqttService mqttService;

    public PushCallback(MqttPushClient client, MqttConfig mqttConfiguration) {
        this.client = client;
        this.mqttConfiguration = mqttConfiguration;
    }

    @Override
    public void connectionLost(Throwable cause) {
        /** 连接丢失后，一般在这里面进行重连 **/
        if (client != null) {
            while (true) {
                try {
                    log.info("==============》》》[MQTT] 连接丢失，尝试重连...");
                    MqttPushClient mqttPushClient = new MqttPushClient();
                    mqttPushClient.connect(mqttConfiguration);
                    if (MqttPushClient.getClient().isConnected()) {
                        log.info("=============>>重连成功");
                    }
                    break;
                } catch (Exception e) {
                    log.error("=============>>>[MQTT] 连接断开，重连失败！<<=============");
                    continue;
                }
            }
        }
        log.info(cause.getMessage());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // publish后会执行到这里
        log.info("pushComplete==============>>>" + token.isComplete());
    }

    /**
     * 监听对应的主题消息
     *
     * @param topic
     * @param message
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        log.info("============》》接收消息主题 : " + topic);
        log.info("============》》接收消息Qos : " + message.getQos());
        log.info("============》》接收消息内容原始内容 : " + new String(message.getPayload()));
        log.info("============》》接收消息内容GB2312 : " + new String(message.getPayload(), "GB2312"));
        log.info("============》》接收消息内容UTF-8 : " + new String(message.getPayload(), "UTF-8"));
        try {
            if (topic.equals("datapoint")) {
                String mqttResponseBody = new String(message.getPayload(), "UTF-8");
                mqttService.messageArrived(mqttResponseBody);
            } else if (topic.equals("heartbeat")) {
                String mqttResponseHeartbeat = new String(message.getPayload(), "UTF-8");
                mqttService.messageHeartbeat(mqttResponseHeartbeat);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("============》》接收消息主题异常 : " + e.getMessage());
        }
    }

}
