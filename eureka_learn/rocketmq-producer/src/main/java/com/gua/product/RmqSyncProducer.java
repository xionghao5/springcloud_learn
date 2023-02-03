package com.gua.product;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RmqSyncProducer {
    @Autowired
    private DefaultMQProducer producer;

    public void setMsg(String msgBody) throws Exception {

        // 创建一条消息，并指定topic、tag、body等信息，tag可以理解成标签，对消息进行再归类，RocketMQ可以在消费端对tag进行过滤
        Message msg = new Message("TopicTest" /* Topic */,
                "TagA" /* Tag */,
                msgBody.getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );   //（3）
        // 利用producer进行发送，并同步等待发送结果
        SendResult sendResult = producer.send(msg);   //（4）

        System.out.println(sendResult);

    }
}