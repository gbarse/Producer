package com.example.kafkaProd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Service

public class EntitySaveService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void triggerSaveMessage(String jsonMessage) {
        try {
            kafkaTemplate.send("sampleTopicName", jsonMessage);
            log.info("message has been sent");

        } catch (Exception e) {
            log.error("Error sending message", e);
        }
    }
}
