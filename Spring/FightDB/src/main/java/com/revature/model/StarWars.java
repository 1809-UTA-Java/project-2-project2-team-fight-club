package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "sw")
public class StarWars {
	private String userId;
	private String charId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCharId() {
		return charId;
	}
	public void setCharId(String charId) {
		this.charId = charId;
	}
	public StarWars(String userId, String charId) {
		super();
		this.userId = userId;
		this.charId = charId;
	}
	@Override
	public String toString() {
		return "StarWars [userId=" + userId + ", charId=" + charId + "]";
	}
}
