package com.revature.fightAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("id")
	public String id;
	@JsonProperty("name")
	public String name;

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
