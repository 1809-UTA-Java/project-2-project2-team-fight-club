package com.revature.starwars.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.starwars.model.Person;

@Component
public class CallSwapi implements CommandLineRunner {

	private static void callStarwarsApi() {
//		RestTemplate restTemplate = new RestTemplate();
//		System.out.println("Calling Swapi...");
//		Person person = restTemplate.getForObject("http://swapi.co/api/people/1/?format=json", Person.class);
//		System.out.println("Person's name is " + person.getName());
	}

	@Override
	public void run(String... arg0) throws Exception {
		callStarwarsApi();

	}

}
