package com.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.purple.redis.RedisClientTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com.spring.config/applicationContext-redis.xml" })
public class RedisTest {
	@Autowired
	private RedisClientTemplate redisClientTemplate;
	@Test
	public void test(){
		redisClientTemplate.set("test", "test1");
		System.out.println(redisClientTemplate.get("test"));
	}
}
