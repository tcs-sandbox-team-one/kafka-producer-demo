package com.kafka.springbootkafkaproducerexample.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaEventSource {
	
	String cargoHandlingChannel2 = "cargoHandlingChannel2";

	  @Output(cargoHandlingChannel2) 
	  MessageChannel cargoHandling2();
}
