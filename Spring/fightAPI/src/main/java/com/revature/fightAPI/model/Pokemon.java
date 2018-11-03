package com.revature.fightAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {

	@JsonProperty("pokeID")
	public String pokeID;
	@JsonProperty("pokeName")
	public String pokeName;
	@JsonProperty("battleLevel")
	public String battleLevel;

	public String getPokeID() {
		return pokeID;
	}

	public void setPokeID(String pokeID) {
		this.pokeID = pokeID;
	}

	public String getPokeName() {
		return pokeName;
	}

	public void setPokeName(String pokeName) {
		this.pokeName = pokeName;
	}

	public String getBattleLevel() {
		return battleLevel;
	}

	public void setBattleLevel(String battleLevel) {
		this.battleLevel = battleLevel;
	}

	@Override
	public String toString() {
		return "Pokemon [pokeID=" + pokeID + ", pokeName=" + pokeName + ", battleLevel=" + battleLevel + "]";
	}

}
