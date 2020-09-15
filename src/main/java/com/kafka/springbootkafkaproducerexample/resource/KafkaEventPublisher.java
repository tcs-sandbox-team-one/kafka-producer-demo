package com.kafka.springbootkafkaproducerexample.resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.util.MimeTypeUtils;
import com.kafka.springbootkafkaproducerexample.config.KafkaEventSource;
import com.kafka.springbootkafkaproducerexample.model.User;

@Service
@EnableBinding(KafkaEventSource.class)
public class KafkaEventPublisher {

	private final KafkaEventSource kafkaEventSource;

    public KafkaEventPublisher(KafkaEventSource kafkaEventSource){
        this.kafkaEventSource = kafkaEventSource;
    }

    
    @TransactionalEventListener
    public void kafkaEventSender(User user){
		
    	 System.out.println("before sending messages");
    	 MessageChannel messageChannel = kafkaEventSource.cargoHandling2();
         messageChannel.send(MessageBuilder
                 .withPayload(user)
                 .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                 .build());
		 
    }
}
