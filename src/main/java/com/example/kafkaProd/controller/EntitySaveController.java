package com.example.kafkaProd.controller;

import com.example.kafkaProd.service.EntitySaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@RestController
@RequestMapping("/api")
public class EntitySaveController {

    @Autowired
    private EntitySaveService service;

    @PostMapping("/send")
    public void triggerRandomUpdate(@RequestBody String jsonMessage) {
        try {
            log.info("Triggering kafka message with: {}", jsonMessage);
            service.triggerSaveMessage(jsonMessage);

        } catch (Exception e) {
            log.error("Error triggering random update", e);

        }
    }
}
