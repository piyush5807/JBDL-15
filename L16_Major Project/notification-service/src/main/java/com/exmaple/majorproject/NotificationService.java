package com.exmaple.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SimpleMailMessage simpleMailMessage;

    @Autowired
    JavaMailSender javaMailSender;

    private static final String TOPIC_TRANSACTION_COMPLETE = "transaction_complete";

    @KafkaListener(topics = {TOPIC_TRANSACTION_COMPLETE}, groupId = "jbdl-15")
    public void sendNotification(String message) throws JsonProcessingException {

        JSONObject jsonObject = objectMapper.readValue(message, JSONObject.class);
        String email = (String)jsonObject.get("email");
        String emailMsg = (String) jsonObject.get("message");

        simpleMailMessage.setText(emailMsg);
        simpleMailMessage.setFrom("geeksforgeeks.jbld15@gmail.com");
        simpleMailMessage.setTo(email);

        javaMailSender.send(simpleMailMessage);

    }

}
