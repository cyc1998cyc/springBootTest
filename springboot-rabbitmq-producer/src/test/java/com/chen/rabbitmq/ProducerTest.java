package com.chen.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 陈宇超
 * 0:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApp.class)
public class ProducerTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void helloTest(){
        String msg = "hello rabbitmq!";
        rabbitTemplate.convertAndSend("","boot_hello_queue",msg);
    }
}
