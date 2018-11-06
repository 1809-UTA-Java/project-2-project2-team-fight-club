package com.revature.fightAPI.controller;

import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.revature.fightAPI.model.Team;
import com.revature.fightAPI.model.Teams;

@RestController
@RequestMapping(value = "/get")
public class FightController {

	@GetMapping(value = "/winner")
	public String getWinner() {

		System.out.println("Inside /get/winner");

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "http://localhost:8083/api/challengers";
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Teams> swResponse = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, Teams.class);
//		
//
//		if (swResponse.getStatusCode() == HttpStatus.OK) {
//			/*
//			 for(Team team : swResponse.getBody()) { 
//				 System.out.println(team.getStarwars() + " " + team.getPokemon() + " "); 
//				 //User user1 = team.getUser();
//				 String winner = team.getUser().name;
//				 return winner;
//			 }
//			*/
//			
//			// Store Json data 
		Teams data = swResponse.getBody();
//			
//			Uncomment to display information to console
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
		System.out.println(data.teams.get(1).starwars.get(0).name);
		System.out.println(data.teams.get(1).starwars.get(0).battleRank);
		System.out.println("Pokemon");
		System.out.println(data.teams.get(1).pokemon.get(0).pokeName);
		System.out.println(data.teams.get(1).pokemon.get(0).battleLevel);
		
		
		int rank1 = 0;
		int rank2 = 0;
	
		for (int i = 0; i < data.teams.get(0).starwars.size(); i++) {
			rank1 += Integer.parseInt(data.teams.get(0).starwars.get(i).battleRank);
		}
		
		for (int i = 0; i < data.teams.get(1).starwars.size(); i++) {
			rank2 += Integer.parseInt(data.teams.get(1).starwars.get(i).battleRank);
		}
		
		int level1 = 0;
		int level2 = 0;
		
		for (int i = 0; i < data.teams.get(0).pokemon.size(); i++) {
			level1 += Integer.parseInt(data.teams.get(0).pokemon.get(i).battleLevel);
		}
		
		for (int i = 0; i < data.teams.get(1).pokemon.size(); i++) {
			level2 += Integer.parseInt(data.teams.get(1).pokemon.get(i).battleLevel);
		}
		
		int team1rank = level1 + rank1;
		int team2rank = level2 + rank2;
		
		
		System.out.println("TTEESSTT");
		System.out.println(rank1);
		System.out.println(rank2);
		
		System.out.println(level1);
		System.out.println(level2);
		// determine winner8

		Team team1 = new Team();
		Team team2 = new Team();

		team1 = data.getTeams().get(0);
		team2 = data.getTeams().get(1);
		String result;

		if (team1rank > team2rank) {
			result = team1.toString()+ '\n'+'\n' + "Defeats" + '\n'+'\n' + team2.toString();
		} else if (team1rank < team2rank) {
			result = team2.toString() + '\n'+'\n' + "Defeats" + '\n'+'\n' + team1.toString();
		} else {
			result = team2.toString() + '\n'+'\n' + "Fights" + '\n'+'\n' + team1.toString() + '\n'+'\n'+" To a DRAW!!!";
		}

//		} else {
//			System.out.println("ERR");
//		}

//		return null;
//
//		return "Complete";

		return result;
	}

}
