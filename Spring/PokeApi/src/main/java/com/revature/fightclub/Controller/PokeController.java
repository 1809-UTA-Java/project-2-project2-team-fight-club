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
	public List<Pokemon> getPoke(){
		List<Pokemon> pokeList = new ArrayList<>();
		Random random = new Random();
		int numofpoke = random.nextInt(4) + 1;
		
		for(int pokecounter=1; pokecounter<=numofpoke; pokecounter++){
		Pokemon pokemon = new Pokemon();
		PokeApi pokeApi = new PokeApiClient();
		int index = random.nextInt(802) + 1;
		int battleLevel = random.nextInt(10) + 1;
		//String pokemon = pokeApi.getPokemonSpecies(rng).getId() + " " + pokeApi.getPokemonSpecies(rng).getName() + " " + battleLevel;
		pokemon.setPokeID(index);
		pokemon.setPokeName(pokeApi.getPokemonSpecies(index).getName());
		pokemon.setBattleLevel(battleLevel);
		pokeList.add(pokemon);
		}
		
		return pokeList;
	}
	
	@RequestMapping("/get")
	public List<String> getPoke(int numofpoke){
		List<String> pokeList = new ArrayList<String>();
		Random random = new Random();
		
		for(int pokecounter=1; pokecounter<=numofpoke; pokecounter++){
		PokeApi pokeApi = new PokeApiClient();
		int rng = random.nextInt(802) + 1;
		int battleLevel = random.nextInt(10) + 1;
		String pokemon = pokeApi.getPokemonSpecies(rng).getId() + "," + pokeApi.getPokemonSpecies(rng).getName() + ","
				+ battleLevel;
		pokeList.add(pokemon);
		}
		
		return pokeList;
	}
}