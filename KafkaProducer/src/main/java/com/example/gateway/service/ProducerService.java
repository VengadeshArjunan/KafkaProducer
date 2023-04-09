package com.example.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.gateway.model.Product;



@Service
public class ProducerService {
	Logger logger = LoggerFactory.getLogger(ProducerService.class);
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(String message) {
		kafkaTemplate.send("test-topic",message);
		logger.info(String.format("Sending message -> %s", message));
	}

	public void send(Product product) {	
		kafkaTemplate.send("test-topic",product);
		logger.info(String.format("Sending message -> %s", product.toString()));
	}
}
