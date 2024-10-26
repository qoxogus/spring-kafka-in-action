package com.spring.kafka.producer;

import com.spring.kafka.constant.KafkaTopic;
import com.spring.kafka.dto.MessageDto;
import com.spring.kafka.service.KafkaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaService kafkaService;

    public MessageDto send(String message) {
        log.info("[Producer] send message to kafka");
        kafkaService.send(KafkaTopic.DEFAULT_TOPIC, message);

        return MessageDto.fromValue(message);
    }

    public MessageDto send(String key, String message) {
        log.info("[Producer] send message to kafka with key");
        kafkaService.send(KafkaTopic.DEFAULT_TOPIC, key, message);

        return MessageDto.of(key, message);
    }
}
