package com.example.jbdl.demosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MyUser user1 = MyUser.builder()
				.username("ABC")
				.authorities("std")
				.password(passwordEncoder.encode("ABC123"))
				.build();

		MyUser user2 = MyUser.builder()
				.username("DEF")
				.authorities("std:adm")
				.password(passwordEncoder.encode("DEF123"))
				.build();

		userRepository.saveAll(Arrays.asList(user1, user2));
	}
}
