//package com.jhaavesh.Taskmanagementsystem.Service;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class GeminiService {
//
//    @Value("${gemini.api.key}")
//    private String apiKey;
//
//    public String askGemini(String question) {
//
//        String url =
//                "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key="
//                        + apiKey;
//
//        String requestBody = """
//        {
//          "contents":[
//            {
//              "parts":[{"text":"%s"}]
//            }
//          ]
//        }
//        """.formatted(question);
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> entity =
//                new HttpEntity<>(requestBody, headers);
//
//        return restTemplate.postForObject(url, entity, String.class);
//    }
//}
