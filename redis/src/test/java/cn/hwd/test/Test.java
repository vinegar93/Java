package cn.hwd.test;

import redis.clients.jedis.Jedis;

public class Test {

	@org.junit.Test
	public void test() {
        Jedis jedis = new Jedis("192.168.238.128");
        jedis.auth("123456");
        String result = jedis.ping();
        System.out.println(result);
	}

}
