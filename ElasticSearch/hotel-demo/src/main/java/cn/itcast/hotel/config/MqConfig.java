package cn.itcast.hotel.config;

import cn.itcast.hotel.constants.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-28
 */
@Configuration
public class MqConfig {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(MqConstants.HOTEL_EXCHANGE, true, false);
    }

    @Bean
    public Queue insertQueue(){
        return new Queue(MqConstants.HOTEL_INSERT_QUEUE, true);
    }

    @Bean
    public Queue deleteQueue(){
        return new Queue(MqConstants.HOTEL_DELETE_QUEUE, true);
    }

    @Bean
    public Binding insertQueueBinding(Queue insertQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(insertQueue).to(topicExchange).with(MqConstants.HOTEL_INSERT_KEY);
    }

    @Bean
    public Binding deleteQueueBinding(Queue deleteQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(deleteQueue).to(topicExchange).with(MqConstants.HOTEL_DELETE_KEY);
    }
}
