package com.revature.fightAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("id")
	public String id;
	@JsonProperty("first")
	public String first;
	@JsonProperty("last")
	public String last;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first=" + first + ", last=" + last + "]";
	}

}
