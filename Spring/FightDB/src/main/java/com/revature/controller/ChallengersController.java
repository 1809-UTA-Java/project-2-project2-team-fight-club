package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/challengers")
	public List<Team> challengers() {
		Team teamA = buildTeam();
		Team teamB = buildTeam();
		List<Team> challengers = null;
		challengers.add(teamA);
		challengers.add(teamB);
		
		return challengers;
	}
	
	private Team buildTeam() {
		Team team = null;
		User user = users_repo.findUser().get(0);
		team.setUser(user);
		team.setPokemon(pokemon_repo.findByUserId(user.getId()));
		team.setStarwars(sw_repo.findByUserId(user.getId()));
		return team;
	}
	
	@PostMapping("/addTeam")
	public void addTeam(@RequestBody Team team) {
		users_repo.save(team.getUser());
		List<Pokemon> pokemons = team.getPokemon();
		List<StarWars> sw =team.getStarwars();
		pokemon_repo.saveAll(pokemons);
		sw_repo.saveAll(sw);
	}
}
