package com.yildiz.kafka.demo.kafka_demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.yildiz.kafka.demo.kafka_demo.dto.Customer;

@Service
public class KafkaProducer {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, Customer> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(Customer customer) {
		
		log.info(String.format("Message sent -> %s", customer.toString()));
		
		Message<Customer> message = MessageBuilder
				.withPayload(customer)
				.setHeader(KafkaHeaders.TOPIC, "customer")
				.build();
		
		kafkaTemplate.send(message);
		
	}

}
