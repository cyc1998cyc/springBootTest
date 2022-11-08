package com.chen.rabbitmq.pubblish;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 陈宇超
 * 23:00
 */
public class Producer {
    static final String FANOUT_EXCHAGE = "fanout_exchange";
    static final String FANOUT_QUEUE_1 = "fanout_queue1";
    static final String FANOUT_QUEUE_2 = "fanout_queue2";

    public static void main(String[] args) throws Exception {
        //1创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
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

        //2创建连接
        Connection connection = connectionFactory.newConnection();

        //3创建频道
        Channel channel = connection.createChannel();

        /**
         * 声明交换机
         * 参数1：交换机名称
         * 参数2：交换机类型，fanout、topic、direct、headers
         * 参数3：是否定义持久化
         * 参数4：是否在不使用的时候自动删除
         */

        channel.exchangeDeclare(FANOUT_EXCHAGE, BuiltinExchangeType.FANOUT,true,true,null);

        // 声明（创建）队列
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其它参数
         */
        channel.queueDeclare(FANOUT_QUEUE_1, true, false, false, null);
        channel.queueDeclare(FANOUT_QUEUE_2, true, false, false, null);

        //队列绑定交换机
        channel.queueBind(FANOUT_QUEUE_1, FANOUT_EXCHAGE, "");
        channel.queueBind(FANOUT_QUEUE_2, FANOUT_EXCHAGE, "");

        for (int i = 1; i <= 10; i++) {
            // 发送信息
            String message = "你好；小兔子！发布订阅模式--" + i;
            /**
             * 参数1：交换机名称，如果没有指定则使用默认Default Exchage
             * 参数2：路由key,简单模式可以传递队列名称
             * 参数3：消息其它属性
             * 参数4：消息内容
             */
            channel.basicPublish(FANOUT_EXCHAGE, "", null, message.getBytes());
            System.out.println("已发送消息：" + message);
        }

        // 关闭资源
        channel.close();
        connection.close();
    }
}