package com.purple.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MQProducerImpl implements MQProducer{
	@Autowired
    private AmqpTemplate amqpTemplate;
	@Override
	public void sendDataToQueue(String queueKey, Object object) {
		 try {
	            amqpTemplate.convertAndSend(queueKey, object);
	        } catch (Exception e) {
	            log.error(e);
	        }
	}
}
