package com.revature.fightAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StarWars {
	
	@JsonProperty("id")
	public String id;
	@JsonProperty("name")
	public String name;
	@JsonProperty("battleRank")
	public String battleRank;
	@JsonProperty("url")
	public String url;

	/*
	@JsonProperty("name")
	public String name;
	@JsonProperty("height")
	public String height;
	@JsonProperty("mass")
	public String mass;
	@JsonProperty("hair_color")
	public String hair_color;
	@JsonProperty("skin_color")
	public String skin_color;
	@JsonProperty("eye_color")
	public String eye_color;
	@JsonProperty("birth_year")
	public String birth_year;
	@JsonProperty("gender")
	public String gender;
	@JsonProperty("homeworld")
	public String homeworld;
	@JsonProperty("films")
	public String films;
	@JsonProperty("species")
	public String species;
	@JsonProperty("vehicles")
	public String vehicles;
	@JsonProperty("starships")
	public String starships;
	@JsonProperty("created")
	public String created;
	@JsonProperty("edited")
	public String edited;
	@JsonProperty("url")
	public String url;
	*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBattleRank() {
		return battleRank;
	}
	public void setBattleRank(String battleRank) {
		this.battleRank = battleRank;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "StarWars [id=" + id + ", name=" + name + ", battleRank=" + battleRank + ", url=" + url + "]";
	}

}
