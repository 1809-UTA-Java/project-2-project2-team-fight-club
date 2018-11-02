package com.revature.fightclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

@SpringBootApplication
public class PokeApiApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PokeApiApplication.class, args);
		List<String> pokeList = new ArrayList<String>();
		Random random = new Random();
		int numofpoke = random.nextInt(4) + 1;
		
		for(int pokecounter=1; pokecounter<=numofpoke; pokecounter++){
		PokeApi pokeApi = new PokeApiClient();
		int rng = random.nextInt(802) + 1;
		int battleLevel = random.nextInt(10) + 1;
		String pokemon = pokeApi.getPokemonSpecies(rng).getId() + "," + pokeApi.getPokemonSpecies(rng).getName() + ","
				+ battleLevel;
		pokeList.add(pokemon);
		}
		for(String poke : pokeList){
			System.out.println(poke);
		}
	}
}