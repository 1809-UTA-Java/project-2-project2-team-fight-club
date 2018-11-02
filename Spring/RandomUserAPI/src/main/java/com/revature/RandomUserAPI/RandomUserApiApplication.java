package com.revature.RandomUserAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.revature.RandomUserAPI.model.User;

@SpringBootApplication
public class RandomUserApiApplication {
	private static final Logger log = LoggerFactory.getLogger(RandomUserApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RandomUserApiApplication.class, args);
	}
	
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			User user = restTemplate.getForObject("https://randomuser.me/api/?inc=name,id", User.class);
			log.info(user.toString());
		};
	}
}
