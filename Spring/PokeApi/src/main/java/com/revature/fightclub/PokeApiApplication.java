package com.revature.fightclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.fightclub.Model.Pokemon;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

@SpringBootApplication
public class PokeApiApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PokeApiApplication.class, args);
		List<Pokemon> pokeList = new ArrayList<>();
		Random random = new Random();
		int numofpoke = random.nextInt(4) + 1;
		
		for(int pokecounter=1; pokecounter<=numofpoke; pokecounter++){
			Pokemon pokemon = new Pokemon();
			PokeApi pokeApi = new PokeApiClient();
			int index = random.nextInt(802) + 1;
			int battleLevel = random.nextInt(10) + 1;
			pokemon.setPokeID(index);
			pokemon.setPokeName(pokeApi.getPokemonSpecies(index).getName());
			pokemon.setBattleLevel(battleLevel);
			pokeList.add(pokemon);
		}
		for(Pokemon poke : pokeList){
			System.out.println(poke);
		}
	}
}