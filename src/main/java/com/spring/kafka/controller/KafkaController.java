package com.spring.kafka.controller;

import com.spring.kafka.dto.MessageDto;
import com.spring.kafka.dto.MessageRequest;
import com.spring.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping(value = "/kafka/messages")
    public ResponseEntity<?> sendToKafka(@RequestBody MessageRequest messageRequest) {
        MessageDto messageDto = kafkaProducer.send(UUID.randomUUID().toString(), messageRequest.getMessage());

        return new ResponseEntity<>(messageDto, HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }
}
