package com.test.mq;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.purple.mq.MQProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com.spring.config/applicationContext-all.xml" })
public class MQTest {
	@Autowired
	private MQProducer mqProducer;

	final String queue_key = "uc_queue_key";

	@Test
	public void test() throws InterruptedException {
		Map<String, Object> msg = new HashMap<>();
		msg.put("data", "hello,rabbmitmq!");
		mqProducer.sendDataToQueue(queue_key, msg);
	}
}
