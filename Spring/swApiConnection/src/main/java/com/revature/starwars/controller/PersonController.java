package com.revature.starwars.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.starwars.component.CallSwapi;

@RestController
public class PersonController {
	
	CallSwapi callSwapi;
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	public PersonController(CallSwapi callSwapi) {
		super();
		this.callSwapi = callSwapi;
	}
	
	@RequestMapping("/get") 
	public Object getPerson() { // Returns to browser JSON object of person from SWAPI
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		httpHeader.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeader);
		Object person = restTemplate.exchange("https://swapi.co/api/people/2/", HttpMethod.GET, entity, Object.class);
		return person;
	}
	

	

}
