package com.chen.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 陈宇超
 * 0:44
 */
@Configuration
public class RabbitConfig {

    @Bean("boot_hello_queue")
    public Queue queue(){
        //String queue,  队列名
        // boolean durable, 持久化
        // boolean exclusive, 排他的
        // boolean autoDelete, 自动删除
        // Map<String, Object> arguments 属性
        return new Queue("boot_hello_queue",true,false,false,null);
    }

    //发布订阅模式
    //交换机名称
    public static final String FANOUT_EXCHAGE = "boot_fanout_exchange";
    //队列名称
    public static final String FANOUT_QUEUE_1 = "boot_fanout_queue_1";
    //队列名称
    public static final String FANOUT_QUEUE_2 = "boot_fanout_queue_2";

    @Bean(FANOUT_QUEUE_1)
    public Queue FANOUT_QUEUE_1(){
        return new Queue(FANOUT_QUEUE_1,true,false,false,null);
    }
    @Bean(FANOUT_QUEUE_2)
    public Queue FANOUT_QUEUE_2(){
        return new Queue(FANOUT_QUEUE_2,true,false,false,null);
    }
    @Bean(FANOUT_EXCHAGE)
    public Exchange FANOUT_EXCHAGE(){
        return ExchangeBuilder.fanoutExchange(FANOUT_EXCHAGE).durable(true).build();
    }
    @Bean
    public Binding FANOUT_QUEUE_1_FANOUT_EXCHAGE(@Qualifier(FANOUT_QUEUE_1) Queue queue,
                                                 @Qualifier(FANOUT_EXCHAGE) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
    @Bean
    public Binding FANOUT_QUEUE_2_FANOUT_EXCHAGE(@Qualifier(FANOUT_QUEUE_2) Queue queue,
                                                 @Qualifier(FANOUT_EXCHAGE) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    //作业
    //routing模式

    //topic模式


}
