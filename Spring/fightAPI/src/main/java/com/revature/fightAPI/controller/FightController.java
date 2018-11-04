package com.revature.fightAPI.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
import com.revature.fightAPI.model.Team;
import com.revature.fightAPI.model.User;

@RestController
@RequestMapping(value = "/get")
public class FightController {

	@GetMapping(value = "/winner")
	public String getWinner() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "http://localhost:8083/challengers";
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Team[]> swResponse = restTemplate.exchange(resourceURL, HttpMethod.GET, entity,
				Team[].class);
		

		if (swResponse.getStatusCode() == HttpStatus.OK) {
			
			 for(Team team : swResponse.getBody()) { 
				 System.out.println(team.getStarwars() + " " + team.getPokemon() + " "); 
				 //User user1 = team.getUser();
				 String winner = team.getUser().name;
				 return winner;
			 }

		} else {
			System.out.println("ERR");
		}

		return null;
	}

}
