package com.chen.rabbitmq.pubblish;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 陈宇超
 * 23:35
 */
public class Consumer1 {

    static final String FANOUT_EXCHAGE = "fanout_exchange";
    static final String FANOUT_QUEUE_1 = "fanout_queue1";
    static final String FANOUT_QUEUE_2 = "fanout_queue2";
    public static void main(String[] args) throws Exception {
        //1创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机地址;默认为 localhost
        connectionFactory.setHost("localhost");
        //连接端口;默认为 5672
        connectionFactory.setPort(5672);
        //虚拟主机名称;默认为 /
        connectionFactory.setVirtualHost("/");
        //连接用户名；默认为guest
        connectionFactory.setUsername("chen");
        //连接密码；默认为guest
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
        channel.queueDeclare(FANOUT_QUEUE_1,true,false,false,null);
        channel.queueDeclare(FANOUT_QUEUE_2,true,false,false,null);

        // 声明交换机
        // String exchange,  交换机名称
        // BuiltinExchangeType type, 交换机类型
        // boolean durable,  持久化
        // boolean autoDelete, 自动删除
        // Map<String, Object> arguments 属性
        channel.exchangeDeclare(FANOUT_EXCHAGE, BuiltinExchangeType.FANOUT,true,false,null);

        //队列绑定交换机
        // String queue, 队列名称
        // String exchange, 交换机名称
        // String routingKey 路由键
        channel.queueBind(FANOUT_QUEUE_1,FANOUT_EXCHAGE,"");
        channel.queueBind(FANOUT_QUEUE_2,FANOUT_EXCHAGE,"");


        //4监听某个队列
        // String queue, 监听的队列名
        // boolean autoAck, 是否自动应答
        // Consumer callback 回调函数，收到消息，我要干啥
        com.rabbitmq.client.Consumer consumer=new DefaultConsumer(channel){
            // 回调函数，收到消息，我要干啥
            //  String consumerTag, 消费者标签
            // Envelope envelope, 信封 保存很多信息
            // AMQP.BasicProperties properties, 属性
            // byte[] body  消息字节数组
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //业务逻辑

                //现在的业务逻辑就是打印
//                System.out.println("consumerTag:"+consumerTag);
//                System.out.println("Exchange:"+envelope.getExchange());
//                System.out.println("RoutingKey:"+envelope.getRoutingKey());
//                System.out.println("DeliveryTag:"+envelope.getDeliveryTag()); //消息id

                System.out.println(new String(body));
            }
        };
        channel.basicConsume(FANOUT_QUEUE_1,true,consumer);

        //5 千万别关闭连接，要不然queue有了消息 推不过来了
//        channel.close();
//        connection.close();



    }
}