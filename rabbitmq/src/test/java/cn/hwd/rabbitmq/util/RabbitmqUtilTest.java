package cn.hwd.rabbitmq.util;

import org.junit.Test;

public class RabbitmqUtilTest {

	@Test
	public void testSend() {
		RabbitmqUtil rabbitmqUtil = new RabbitmqUtil();
		rabbitmqUtil.send("Hello RabbitMQ");
	}

	@Test
	public void testReceive() {
		RabbitmqUtil rabbitmqUtil = new RabbitmqUtil();
		rabbitmqUtil.receive();
	}

}
