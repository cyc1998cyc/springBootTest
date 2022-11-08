package com.chen.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 陈宇超
 * 23:00
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        //1创建连接工厂
        ConnectionFactory connectionFactory=new ConnectionFactory();
        //连接的ip
        connectionFactory.setHost("localhost");
        //连接的端口
        connectionFactory.setPort(5672);
        //设置虚拟主机
        connectionFactory.setVirtualHost("/");
        //设置用户名
        connectionFactory.setUsername("chen");
        //设置密码
        connectionFactory.setPassword("1812244d");

        //2创建长连接
        Connection connection = connectionFactory.newConnection();
        //3创建channel
        Channel channel = connection.createChannel();
        //声明队列
        //String queue,  队列名
        // boolean durable, 持久化
        // boolean exclusive, 排他的
        // boolean autoDelete, 自动删除
        // Map<String, Object> arguments 属性
        channel.queueDeclare("chen",true,false,false,null);

        //4发消息
        // String exchange,  交换机
        // String routingKey, 路由键
        // AMQP.BasicProperties props, 属性
        // byte[] body 消息      string byte[] char[]如何相互转换的？
        String msg="hello rabbitmq!";
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("","chen",null,msg.getBytes());
        }

        //5关闭连接  资源关闭的顺序，先关后出来的资源，最后关，第一个资源
        channel.close();
        connection.close();
    }
}
