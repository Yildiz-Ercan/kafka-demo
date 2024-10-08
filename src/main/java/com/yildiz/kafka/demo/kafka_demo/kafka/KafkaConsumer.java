package com.yildiz.kafka.demo.kafka_demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yildiz.kafka.demo.kafka_demo.dto.Customer;

@Service
public class KafkaConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "customer", groupId = "myGroup")
	public void consume(Customer customer) {
		log.info(String.format("Message received: %s", customer.toString()));
	}
	

}
