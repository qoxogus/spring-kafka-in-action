package com.spring.kafka.dto;

import lombok.Getter;

@Getter
public class MessageDto {

    private String key;
    private String data;

    private MessageDto(String key, String data) {
        this.key = key;
        this.data = data;
    }

    public static MessageDto fromValue(String data) {
        return new MessageDto(null, data.toString());
    }

    public static MessageDto of(Object key, Object data) {
        return new MessageDto(key.toString(), data.toString());
    }
}
