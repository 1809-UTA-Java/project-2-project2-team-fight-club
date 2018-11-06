package com.revature.fightAPI.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Teams {
	@JsonProperty("teams")
	public List<Team> teams;

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "Teams [teams=" + teams + "]";
	}
	
}