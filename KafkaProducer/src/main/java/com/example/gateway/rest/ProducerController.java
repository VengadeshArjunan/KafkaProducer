package com.example.gateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gateway.service.ProducerService;

@RestController
public class ProducerController {
	@Autowired
	ProducerService producerService;
	
	@GetMapping("/producer")
	public String message(@RequestParam String message) {
		producerService.sendMessage(message);
		return "Message Published successfully";
	}
}
