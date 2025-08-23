package cn.itcast.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: chs
 * Description: 惰性队列配置
 * CreateTime: 2024-12-30
 */
@Configuration
public class LazyQueueConfig {
    // 声明一个惰性队列
    @Bean
    public Queue lazyQueue(){
        return QueueBuilder.durable("lazy.queue")
                .lazy() // 开启x-queue-mode为lazy
                .build();
    }
}
