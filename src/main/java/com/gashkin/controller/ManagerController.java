package com.gashkin.controller;

import com.gashkin.service.ApiClientService;
import com.gashkin.service.KafkaPublisherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ApiClientService apiClientService;
    private final KafkaPublisherService kafkaPublisherService;

    public ManagerController(ApiClientService apiClientService, KafkaPublisherService kafkaPublisherService) {
        this.apiClientService = apiClientService;
        this.kafkaPublisherService = kafkaPublisherService;
    }

    @GetMapping("/fetch-and-publish")
    public String fetchAndPublish(@RequestParam String apiUrl, @RequestParam String topic) {
        String data = apiClientService.getDataFromApi(apiUrl);
        kafkaPublisherService.publishMessage(topic, data);
        return "Published data to Kafka topic: " + topic;
    }
}