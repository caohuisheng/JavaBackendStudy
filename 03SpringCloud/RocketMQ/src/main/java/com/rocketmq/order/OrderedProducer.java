package com.rocketmq.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 全局有序消息生产者
 */
public class OrderedProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");

        // 设置Queue数量为1
        producer.setDefaultTopicQueueNums(1);
        producer.start();

        for (int i = 0; i < 100; i++) {
            // 为了演示简单，使用整型数作为orderId
            Integer orderId = i;
            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("TopicA", "TagA", body);
            // 将orderId作为消息key
            msg.setKeys(orderId.toString());
            SendResult sendResult = producer.send(msg);

            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
