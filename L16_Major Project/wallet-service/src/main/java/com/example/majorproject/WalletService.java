package com.example.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private static final String USER_CREATE_TOPIC = "user_create";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    ObjectMapper objectMapper;


    @KafkaListener(topics = {USER_CREATE_TOPIC}, groupId = "jbdl-15")
    public void createWallet(String msg) throws JsonProcessingException {
        JSONObject jsonObject = objectMapper.readValue(msg, JSONObject.class);

        String userId =  (String)jsonObject.get("userId");
        int amount  = (Integer) jsonObject.get("amount");

        Wallet wallet = Wallet.builder()
                .userId(userId)
                .balance(amount)
                .build();

        walletRepository.save(wallet);

    }

    @KafkaListener(topics = {USER_CREATE_TOPIC}, groupId = "jbdl-15")
    public void createWallet2(String msg) throws JsonProcessingException {
        JSONObject jsonObject = objectMapper.readValue(msg, JSONObject.class);

        String userId =  (String)jsonObject.get("userId");
        int amount  = (Integer) jsonObject.get("amount");

        Wallet wallet = Wallet.builder()
                .userId(userId)
                .balance(amount)
                .build();

        walletRepository.save(wallet);

    }
}
