package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "sw")
public class StarWars {
	@Id
	private String id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StarWars [userId=" + userId + ", charId=" + charId + ", id=" + id + "]";
	}
	public StarWars(String userId, String charId, String id) {
		super();
		this.userId = userId;
		this.charId = charId;
		this.id = id;
	}
	
}
