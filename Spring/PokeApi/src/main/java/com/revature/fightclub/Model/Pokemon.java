package com.revature.fightclub.Model;

import javax.persistence.Entity;

@Entity
public class Pokemon {
	int pokeID;
	String pokeName;
	int battleLevel;

	@Override
	public String toString() {
		return "Pokemon [pokeID=" + pokeID + ", pokeName=" + pokeName + ", battleLevel=" + battleLevel + "]";
	}

	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(int pokeID, String pokeName, int battleLevel) {
		super();
		this.pokeID = pokeID;
		this.pokeName = pokeName;
		this.battleLevel = battleLevel;
	}

	public int getPokeID() {
		return pokeID;
	}

	public void setPokeID(int pokeID) {
		this.pokeID = pokeID;
	}

	public String getPokeName() {
		return pokeName;
	}

	public void setPokeName(String pokeName) {
		this.pokeName = pokeName;
	}

	public int getBattleLevel() {
		return battleLevel;
	}

	public void setBattleLevel(int battleLevel) {
		this.battleLevel = battleLevel;
	}
}
