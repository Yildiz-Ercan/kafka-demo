package com.yildiz.kafka.demo.kafka_demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yildiz.kafka.demo.kafka_demo.dto.Message;

@Service
public class KafkaProducer {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(Message message) {
		String myMessage = message.getMessage();
		log.info(String.format("Message sent %s", myMessage));
		kafkaTemplate.send("customer", myMessage);
	}

}
