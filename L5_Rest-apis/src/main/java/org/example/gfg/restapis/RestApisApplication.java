package org.example.gfg.restapis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApisApplication{

	public static void main(String[] args) {
		SpringApplication.run(RestApisApplication.class, args);

		System.out.println("Hello!!!");
	}

}
