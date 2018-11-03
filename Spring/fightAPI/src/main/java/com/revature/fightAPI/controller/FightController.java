package com.revature.fightAPI.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.fightAPI.model.StarWars;

@RestController
@RequestMapping(value = "/api")
public class FightController {

	@GetMapping(value = "/getwinner")
	public StarWars getWinner() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "http://localhost:8838/get";
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<StarWars> swResponse = restTemplate.exchange(resourceURL, HttpMethod.GET, entity,
				StarWars.class);
		ResponseEntity<StarWars> swResponse2 = restTemplate.exchange(resourceURL, HttpMethod.GET, entity,
				StarWars.class);
		if (swResponse.getStatusCode() == HttpStatus.OK) {
			/*
			 * for(StarWars starwars : response.getBody()) { System.out.println(starwars.id
			 * + " " + starwars.name + " "); }
			 */

			StarWars sw = swResponse.getBody();
			StarWars sw2 = swResponse2.getBody();

			System.out.println("Name");
			System.out.println(sw.name);

			System.out.println("Battle rank");
			System.out.println(sw.battleRank);

			System.out.println("Name");
			System.out.println(sw2.name);

			System.out.println("Battle rank");
			System.out.println(sw2.battleRank);

			Integer.valueOf(sw.battleRank);
			if (Integer.valueOf(sw.battleRank) > Integer.valueOf(sw2.battleRank)) {
				System.out.println("Winner: " + sw.name);
				return sw;
			} else if (Integer.valueOf(sw.battleRank) < Integer.valueOf(sw2.battleRank)) {
				System.out.println("Winner: " + sw2.name);
				return sw2;
			} else {
				System.out.println("Draw");
				return null;
			}
		} else {
			System.out.println("ERR");
		}

		/*
		 * Grab character directly from swapi headers.set("APIKEY", "3DPW");
		 * headers.add("user-agent",
		 * "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"
		 * ); String resourceURL= "https://swapi.co/api/people/";
		 */

		return null;
	}

}
