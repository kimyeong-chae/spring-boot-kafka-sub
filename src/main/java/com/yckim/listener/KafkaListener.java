package com.yckim.listener;

import org.springframework.stereotype.Service;

import com.yckim.model.Person;

@Service
public class KafkaListener {

	@org.springframework.kafka.annotation.KafkaListener(topics = "test", group = "group_id")
	public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @org.springframework.kafka.annotation.KafkaListener(topics = "test_json", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Person person) {
        System.out.println("Consumed JSON Message: " + person);
    }
}
