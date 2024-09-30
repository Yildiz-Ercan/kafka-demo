package com.yildiz.kafka.demo.kafka_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.kafka.demo.kafka_demo.dto.Customer;
import com.yildiz.kafka.demo.kafka_demo.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	private KafkaProducer kafkaProducer;

	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping(value = "/publish", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> publishMessage(@RequestBody @Validated Customer customer) {
		kafkaProducer.sendMessage(customer);
		return new ResponseEntity<>("Message was send sucessfully!", HttpStatus.OK);
	}

}
