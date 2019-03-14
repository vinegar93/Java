package cn.hwd.rabbitmq.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RabbitmqUtil {

	private ConnectionFactory factory = null;
	private Connection connection = null;
	private Channel channel = null;
	private String host = "192.168.238.128";
	private String username = "root";
	private String password = "123456";
	private Integer port = 5672;
	private String queueName = "MyQueue";
	
	public void send(String message) {
		try {
			// 创建工厂
			factory = new ConnectionFactory();
			// 设置
			factory.setHost(host);
			factory.setUsername(username);
		    factory.setPassword(password);
		    factory.setPort(port);
		    // 创建连接
			connection = factory.newConnection();
			// 创建通道
			channel = connection.createChannel();
			// 声明队列
			channel.queueDeclare(queueName, false, false, false, null);
			// 发送消息到队列之中
			channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭通道
				channel.close();
				// 关闭连接
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void receive() {
		try {
			factory = new ConnectionFactory();
			factory.setHost(host);
			factory.setUsername(username);
		    factory.setPassword(password);
		    factory.setPort(port);
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(queueName, false, false, false, null);
			// 创建队列消费者
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
	            public void handleDelivery(String consumerTag, Envelope envelope, 
	            		AMQP.BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
	                System.out.println("receive:" + message);
	            }
			};
			// 消息确认机制
			channel.basicConsume(queueName, true, consumer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
}
