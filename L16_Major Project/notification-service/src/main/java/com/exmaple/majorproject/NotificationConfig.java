package com.exmaple.majorproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class NotificationConfig {

    @Bean
        // Not necessary
    Properties getKafkaProps(){
        Properties properties = new Properties();

        // Consumer related Props
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return properties;
    }

    @Bean
    ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    @Bean
    ConsumerFactory<String, String> getConsumerFactory(){
        return new DefaultKafkaConsumerFactory(getKafkaProps());
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(getConsumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }

    // smtp host - Simple mail transfer protocol
    @Bean
    JavaMailSender getMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("geeksforgeeks.jbld15@gmail.com");
        javaMailSender.setPassword("gfg.jbdl15@123");

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.debug", true);
        properties.put("mail.smtp.starttls.enable", true);

        return javaMailSender;

    }

    @Bean
    SimpleMailMessage getMail(){
        return new SimpleMailMessage();
    }

}
