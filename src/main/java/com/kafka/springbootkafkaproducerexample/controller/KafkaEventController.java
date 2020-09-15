package com.kafka.springbootkafkaproducerexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kafka.springbootkafkaproducerexample.model.User;
import com.kafka.springbootkafkaproducerexample.resource.KafkaEventPublisher;

@RestController
@RequestMapping("/kafkaevent")
public class KafkaEventController {

	@Autowired
	private KafkaEventPublisher kafkaEventPublisher;

	/*
	 * @Autowired public KafkaEventController(KafkaEventPublisher
	 * kafkaEventPublisher){ this.kafkaEventPublisher = kafkaEventPublisher; }
	 */

    
    @GetMapping("/publish/{name}")
    public String kafkaHandledEvent(@PathVariable("name") final String name){
    	 User user= new User(name, "IT", 1000L);
    	 kafkaEventPublisher.kafkaEventSender(user);
    	 return "Message sent successfully";
    }
}
