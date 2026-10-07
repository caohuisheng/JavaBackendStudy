package cn.itcast.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-30
 */
@Slf4j
@Component
public class SpringRabbitListener2 {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg) {
        log.info("消费者接收到simple.queue的消息：【{}】", msg);
        // 模拟异常
        System.out.println(1 / 0);
        log.info("消息处理完成！");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "dl.ttl.queue", durable = "true"),
            exchange = @Exchange(name = "dl.ttl.direct"),
            key = "ttl"
    ))
    public void listenDlQueue(String msg){
        log.info("接收到dl.ttl.queue的延迟消息：{}", msg);
    }
}
