package com.revature.fightAPI.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
	
	private User user;
	private List<Pokemon> pokemon;
	private List<StarWars> starwars;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	public List<StarWars> getStarwars() {
		return starwars;
	}

	public void setStarwars(List<StarWars> starwars) {
		this.starwars = starwars;
	}

	@Override
	public String toString() {
		return "Team [user=" + user + ", pokemon=" + pokemon + ", starwars=" + starwars + "]";
	}

}
