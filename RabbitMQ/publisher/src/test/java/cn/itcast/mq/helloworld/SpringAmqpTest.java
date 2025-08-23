package cn.itcast.mq.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String msg = "hello,world!";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName, msg);
            Thread.sleep(20);
        }
    }

    @Test
    public void testFanoutExchange() {
        // 队列名称
        String exchangeName = "itcast.fanout";
        // 消息
        String message = "hello, everyone!";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testSendDirectExchange() {
        // 交换机名称
        String exchangeName = "itcast.direct";
        // 消息
        String message = "红色警报！日本乱排核废水，导致海洋生物变异，惊现哥斯拉！";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }

    /**
     * topicExchange
     */
    @Test
    public void testSendTopicExchange() {
        // 交换机名称
        String exchangeName = "itcast.topic";
        // 消息
        String message = "喜报！孙悟空大战哥斯拉，胜!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "china.news", message);
    }

    @Test
    public void testSendMap() throws InterruptedException {
        // 准备消息
        Map<String,Object> msg = new HashMap<>();
        msg.put("name", "Jack");
        msg.put("age", 21);
        // 发送消息
        rabbitTemplate.convertAndSend("simple.queue",msg);
    }

    @Test
    public void testSendMessage2SimpleQueue(){
        // 消息体
        String message = "hello, spring amqp!";
        // 全局唯一的消息ID，需要封装到CorrelationData中
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        // 添加Callback
        correlationData.getFuture().addCallback(result -> {
            if(result.isAck()){
                log.debug("消息发送成功，ID：{}", correlationData.getId());
            }else{
                log.error("消息发送失败，ID：{}，原因{}", correlationData.getId(), result.getReason());
            }
        }, ex -> {
            log.error("消息发送异常，ID：{}，原因{}", correlationData.getId(), ex.getMessage());
        });
        // 发送消息
        rabbitTemplate.convertAndSend("itcast.direct", "blue", message, correlationData);
        // 休眠一会儿，等待ack回执
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDurableMessage(){
        Message message = MessageBuilder.withBody("hello, ttl queue".getBytes(StandardCharsets.UTF_8))
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .build();
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("simple.queue", message, correlationData);
    }

    @Test
    public void testTTLQueue() {
        // 创建消息
        // String message = "hello, ttl queue";
        Message message = MessageBuilder
                .withBody("hello, ttl message".getBytes(StandardCharsets.UTF_8))
                .setExpiration("5000")
                .build();
        // 消息ID，需要封装到CorrelationData中
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        // 发送消息
        rabbitTemplate.convertAndSend("ttl.direct", "ttl", message, correlationData);
        // 记录日志
        log.debug("发送消息成功");
    }
}
