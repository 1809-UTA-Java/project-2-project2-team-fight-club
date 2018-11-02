package com.revature.fightclub.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.fightclub.Model.Pokemon;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

@RestController
@CrossOrigin
public class PokeController {
	@RequestMapping("/get")
	public List<Pokemon> getPoke() { // Returns an array of pokemon of random
										// size ranging from 1-4
		List<Pokemon> pokeList = new ArrayList<>();
		Random random = new Random();
		int numofpoke = random.nextInt(4) + 1;

		for (int pokecounter = 1; pokecounter <= numofpoke; pokecounter++) {
			Pokemon pokemon = new Pokemon();
			PokeApi pokeApi = new PokeApiClient();
			int index = random.nextInt(802) + 1;
			int battleLevel = random.nextInt(10) + 1;
			pokemon.setPokeID(index);
			pokemon.setPokeName(pokeApi.getPokemonSpecies(index).getName());
			pokemon.setBattleLevel(battleLevel);
			pokeList.add(pokemon);
		}

		return pokeList; //[pokeID=ID, pokeName=Name, battleLevel=Battle level]
	}

	@RequestMapping("/get")
	public List<Pokemon> getPoke(int numofpoke) { // Returns an array of pokemon
													// equal to the number
													// passed to it
		List<Pokemon> pokeList = new ArrayList<>();
		Random random = new Random();

		for (int pokecounter = 1; pokecounter <= numofpoke; pokecounter++) {
			Pokemon pokemon = new Pokemon();
			PokeApi pokeApi = new PokeApiClient();
			int index = random.nextInt(802) + 1;
			int battleLevel = random.nextInt(10) + 1;
			pokemon.setPokeID(index);
			pokemon.setPokeName(pokeApi.getPokemonSpecies(index).getName());
			pokemon.setBattleLevel(battleLevel);
			pokeList.add(pokemon);
		}

		return pokeList; //[pokeID=ID, pokeName=Name, battleLevel=Battle level]
	}
}