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
import com.revature.fightAPI.model.Teams;
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
		ResponseEntity<Teams> swResponse = restTemplate.exchange(resourceURL, HttpMethod.GET, entity,
				Teams.class);
		

		if (swResponse.getStatusCode() == HttpStatus.OK) {
			/*
			 for(Team team : swResponse.getBody()) { 
				 System.out.println(team.getStarwars() + " " + team.getPokemon() + " "); 
				 //User user1 = team.getUser();
				 String winner = team.getUser().name;
				 return winner;
			 }
			*/
			
			// Store Json data 
			Teams data = swResponse.getBody();
			
			/* Uncomment to display information to console
			System.out.println("User");
			System.out.println(data.teams.get(0).user.name);
			System.out.println("StarWars");
			System.out.println(data.teams.get(0).starwars.get(0).name);
			System.out.println(data.teams.get(0).starwars.get(0).battleRank);
			System.out.println("Pokemon");
			System.out.println(data.teams.get(0).pokemon.get(0).pokeName);
			System.out.println(data.teams.get(0).pokemon.get(0).battleLevel);
			System.out.println("User");
			System.out.println(data.teams.get(1).user.name);
			System.out.println("StarWars");
			System.out.println(data.teams.get(1).starwars.get(1).name);
			System.out.println(data.teams.get(1).starwars.get(1).battleRank);
			System.out.println("Pokemon");
			System.out.println(data.teams.get(1).pokemon.get(1).pokeName);
			System.out.println(data.teams.get(1).pokemon.get(1).battleLevel);
			*/
			
			String user1 = data.teams.get(0).user.name;
			String user2 = data.teams.get(1).user.name;
			int team1rank = Integer.valueOf(data.teams.get(0).starwars.get(0).battleRank + data.teams.get(0).pokemon.get(0).battleLevel);
			int team2rank = Integer.valueOf(data.teams.get(0).starwars.get(1).battleRank + data.teams.get(0).pokemon.get(0).battleLevel);
			
					
			// determine winner
			if (team1rank > team2rank) {
				System.out.println("Winner: " + user1);
				return user1;
			} else if (team1rank < team2rank) {
				System.out.println("Winner: " + user2);
				return user2;
			} else {
				System.out.println("Draw");
				return "DRAW";
			}
			
		} else {
			System.out.println("ERR");
		}

		return null;
	}

}