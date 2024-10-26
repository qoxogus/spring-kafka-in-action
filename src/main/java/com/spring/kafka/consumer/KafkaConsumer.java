package com.spring.kafka.consumer;

import com.spring.kafka.constant.KafkaTopic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    /**
     * ConsumerRecord.toString()
     *
     * ConsumerRecord(
     *      topic = spring-kafka-in-action,
     *      partition = 0,
     *      leaderEpoch = 0,
     *      offset = 2,
     *      CreateTime = 1729866199001,
     *      serialized key size = 36,
     *      serialized value size = 9,
     *      headers = RecordHeaders(headers = [], isReadOnly = false),
     *      key = 3d5fb3ae-2558-40cd-9df1-44a00e3a39ac,
     *      value = 호호잇
     * )
     */
    @KafkaListener(topics = KafkaTopic.DEFAULT_TOPIC, autoStartup = "true")
    public void listen(
            @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long receivedTimeStamp,
            @Payload String data
    ) {
        log.info("### [Consumer] listen ###");

        log.info("key : {}", key);
        log.info("topic : {}", topic);
        log.info("partition : {}", partition);
        log.info("offset : {}", offset);
        log.info("receivedTimeStamp : {}", receivedTimeStamp);

        log.info("data : {}", data);
    }
}
