package com.timeline.map.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class SendTelegram {

    @Value("${telegram.baseUrl}")
    private String baseUrl;

    @Value("${telegram.token}")
    private String token;

    @Value("${telegram.chatId}")
    private String chatId;

    public void sendMessage(String text) {
        String url = baseUrl + token + "/sendMessage";

        if (text.length() > 4000) {
            text = text.substring(0, 4000);
        }

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("chat_id", chatId);
        requestMap.put("text", text);

        ResponseEntity<Void> response = restTemplate.postForEntity(url, requestMap, Void.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println("Request Failed");
        }
    }

}
