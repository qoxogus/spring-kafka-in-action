package com.spring.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String message) {
        String key = null;
        send(topic, key, message);
    }

    public void send(String topic, String key, String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info(result.getProducerRecord().toString());
                log.info(result.getRecordMetadata().toString());
            } else {
                log.error("{}", ex.toString());
                ex.printStackTrace();
            }
        });
    }
}
