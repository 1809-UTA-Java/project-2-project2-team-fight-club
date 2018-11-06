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
