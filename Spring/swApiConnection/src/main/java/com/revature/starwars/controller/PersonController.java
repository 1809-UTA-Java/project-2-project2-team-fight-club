package com.revature.starwars.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.starwars.component.PersonComponent;
import com.revature.starwars.model.Person;

@RestController
@CrossOrigin
public class PersonController {

	PersonComponent personComponent;
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	public PersonController(PersonComponent personComponent) {
		super();
		this.personComponent = personComponent;
	}

	@RequestMapping("/get")
	public Person getPerson() { // Returns to browser JSON object of person from
								// SWAPI
		int index = personComponent.random(87);
		String url = "https://swapi.co/api/people/" + index + "/";

		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		httpHeader.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeader);
		Object obj = restTemplate.exchange(url, HttpMethod.GET, entity, Person.class);

		Person person = personComponent.createPerson(obj.toString(), url);

		return person;

	}

}
