package cn.itcast.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: chs
 * Description: 延迟队列配置
 * CreateTime: 2024-12-30
 */
@Configuration
public class TTLMessageConfig {
    @Bean
    public Queue ttlQueue(){
        return QueueBuilder.durable("ttl.queue") // 指定队列名称，并持久化
                .ttl(10000) // 设置队列的超时时间，10秒
                .deadLetterExchange("dl.ttl.direct") // 指定死信交换机
                .build();
    }
    @Bean
    public DirectExchange ttlExchange(){
        return new DirectExchange("ttl.direct");
    }
    @Bean
    public Binding ttlBinding(){
        return BindingBuilder.bind(ttlQueue()).to(ttlExchange()).with("ttl");
    }
}
