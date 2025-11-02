package com.gashkin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ApiClientService {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDataFromApi(String url) {
        // Example GET request to external API
        return restTemplate.getForObject(url, String.class);
    }
}