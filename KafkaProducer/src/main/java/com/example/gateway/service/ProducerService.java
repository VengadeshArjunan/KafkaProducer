package com.example.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class ProducerService {
	Logger logger = LoggerFactory.getLogger(ProducerService.class);
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		kafkaTemplate.send("test-topic",message);
		logger.info(String.format("Sending message -> %s", message));
	}
}
