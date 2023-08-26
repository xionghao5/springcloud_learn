package com.gua.mqtt.pro;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MqttValue {

    /**
     * 链接url
     */
    @Value("${spring.mqtt.url}")
    private String url;

    /**
     * 用户名
     */
    @Value("${spring.mqtt.username}")
    private String username;

    /**
     * 密码
     */
    @Value("${spring.mqtt.password}")
    private String password;

    /**
     * 客户端id
     */
    @Value("${spring.mqtt.client-id}")
    private String clientId;

    /**
     * 通讯标识 id
     */
    @Value("${spring.mqtt.id}")
    private String id;

    /**
     * 主题
     */
    @Value("${spring.mqtt.topics}")
    private String[] topic;

    /**
     * 超时时间
     */
    @Value("${spring.mqtt.timeout}")
    private int timeout;

    /**
     * 心跳检测时间
     */
    @Value("${spring.mqtt.keep-alive}")
    private int keepAlive;

    /**
     * 心跳包级别
     */
    @Value("${spring.mqtt.qos}")
    private int[] qos;

    private int completionTimeout;

}