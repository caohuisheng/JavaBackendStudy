package cn.itcast.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-30
 */
@Configuration
public class CommonConfig {
    @Bean
    public DirectExchange simpleExchange(){
        return new DirectExchange("simple.direct");
    }
    /*@Bean
    public Queue simpleQueue(){
        return QueueBuilder.durable("simple.queue").build();
    }*/
    // 声明普通队列：simple.queue，并指定死信交换机：dl.direct
    @Bean
    public Queue simpleQueue(){
        return QueueBuilder.durable("simple.queue")
                .deadLetterExchange("dl.direct")
                .build();
    }
    @Bean
    public Binding simpleBinding(){
        return BindingBuilder.bind(simpleQueue()).to(simpleExchange()).with("simple");
    }

    // 声明死信交换机：dl.direct
    @Bean
    public DirectExchange dlExchange(){
        return new DirectExchange("dl.direct", true, false);
    }
    // 声明存储死信的队列：dl.queue
    @Bean
    public Queue dlQueue(){
        return new Queue("dl.queue", true);
    }
    // 将死信队列与死信交换机绑定
    @Bean
    public Binding dlBinding(){
        return BindingBuilder.bind(dlQueue()).to(dlExchange()).with("simple");
    }

}
