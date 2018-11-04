package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Pokemon;
import com.revature.model.StarWars;
import com.revature.model.Team;
import com.revature.model.User;
import com.revature.repository.PokemonRepository;
import com.revature.repository.StarWarsRepository;
import com.revature.repository.UserRepository;

@RestController
@RequestMapping ("/api")
public class ChallengersController {
	@Autowired
	private UserRepository users_repo;
	@Autowired
	private StarWarsRepository sw_repo;
	@Autowired
	private PokemonRepository pokemon_repo;
	
	@GetMapping("/userTest")
	public void userTest() {
		System.out.println("Get Request");
	}
	@PostMapping("/user")
	public void postNewUser(@RequestBody User user){
		System.out.println("add user");
		users_repo.save(user);
	}
	
	@PostMapping("/pokemon")
	public void postPokemon(@RequestBody Pokemon pokemon) {
		pokemon.setId(UUID.randomUUID().toString());
		pokemon_repo.save(pokemon);
	}
	
	@PostMapping("/starwars")
	public void postStarWars(@RequestBody StarWars starwars) {
		starwars.setId(UUID.randomUUID().toString());
		sw_repo.save(starwars);
	}
	
	@GetMapping("/challengers")
	public List<Team> challengers() {
		
		Team teamA = buildTeam();
		Team teamB = buildTeam();
		List<Team> challengers = new ArrayList<Team>();
		challengers.add(teamA);
		challengers.add(teamB);
		
		return challengers;
	}
	
	private Team buildTeam() {
		User user = users_repo.findUser().get(0);
		List<Pokemon> pokemon = pokemon_repo.findByUserId(user.getId());
		List<StarWars> sw = sw_repo.findByUserId(user.getId());
		Team team = new Team(user, pokemon, sw);
		
		return team;
		
	}
	
	@PostMapping("/addTeam")
	public void addTeam(@RequestBody Team team) {
		User user = team.getUser();
		users_repo.save(user);
		List<Pokemon> pokemons = team.getPokemon();
		List<StarWars> sw =team.getStarwars();
		
		for(Pokemon mon : pokemons) {
			mon.setUserId(user.getId());
			mon.setId(UUID.randomUUID().toString());
		}
		
		for(StarWars character: sw) {
			character.setUserId(user.getId());
			character.setId(UUID.randomUUID().toString());
		}
		
		pokemon_repo.saveAll(pokemons);
		sw_repo.saveAll(sw);
	}
}
