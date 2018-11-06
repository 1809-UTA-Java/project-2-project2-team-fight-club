package com.revature.fightAPI;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FightApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(FightApiApplication.class, args);
	}
	
	/*
	@Override
	public void run(String... args) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceURL= "http://localhost:7861/get";
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<User> uResponse = restTemplate.exchange(resourceURL,  HttpMethod.GET, entity, User.class);

		if(uResponse.getStatusCode()==HttpStatus.OK) {		
			User u = uResponse.getBody();
	
			System.out.println("first");
			System.out.println(u.first);
		
			System.out.println("last");
			System.out.println(u.last);
			
			System.out.println(uResponse);
		}
		else {
			System.out.println("ERR");
		}
	}
	*/
}
