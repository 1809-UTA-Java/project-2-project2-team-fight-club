package com.revature.fightclub.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.fightclub.Model.Pokemon;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

@RestController
@CrossOrigin
public class PokeController {
	CachingProvider cachingProvider = Caching.getCachingProvider();
	CacheManager cacheManager = cachingProvider.getCacheManager();
	MutableConfiguration<Integer, String> config = new MutableConfiguration<>();
	Cache<Integer, String> pokeCache = cacheManager.createCache("simpleCache", config);
	boolean cached = false;

	@RequestMapping("/get")
	public List<Pokemon> getPoke() { // Returns an array of pokemon of random size ranging from 1-4
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

		return pokeList; // [pokeID=ID, pokeName=Name, battleLevel=Battle level]
	}

	@RequestMapping("/get/{numofpoke}")
	public List<Pokemon> getPoke(@PathVariable("numofpoke") int numofpoke) throws Exception { // Returns an array of pokemon equal to the number passed to it
		PokeCache();
		List<Pokemon> pokeList = new ArrayList<>();
		Random random = new Random();

		for (int pokecounter = 1; pokecounter <= numofpoke; pokecounter++) {
			Pokemon pokemon = new Pokemon();
			PokeApi pokeApi = new PokeApiClient();
			int index = random.nextInt(802) + 1;
			int battleLevel = random.nextInt(10) + 1;
			pokemon.setPokeID(index);
			if (pokeCache.get(index) != null)
				pokemon.setPokeName(pokeCache.get(index));
			else
				pokemon.setPokeName(pokeApi.getPokemonSpecies(index).getName());
			pokemon.setBattleLevel(battleLevel);

			pokeList.add(pokemon);
		}

		return pokeList; // [pokeID=ID, pokeName=Name, battleLevel=Battle level]
	}

	@RequestMapping("/getpokeinfo/{id}") // returns a single pokemon based on the id given
	public Pokemon getPokeInfo(int id) {
		Pokemon pokemon = new Pokemon();
		PokeApi pokeApi = new PokeApiClient();
		Random random = new Random();

		int battleLevel = random.nextInt(10) + 1;
		pokemon.setPokeID(id);
		pokemon.setPokeName(pokeApi.getPokemonSpecies(id).getName());
		pokemon.setBattleLevel(battleLevel);
		return pokemon; // [pokeID=ID, pokeName=Name, battleLevel=Battle level]
	}

	public void PokeCache() {
		PokeApi pokeApi = new PokeApiClient();

		if (cached == false) {
			for (int i = 1; i <= 200; i++) {
				String pokeName = pokeApi.getPokemonSpecies(i).getName();
				pokeCache.put(i, pokeName);
				cached = true;
			}
		}
	}
}