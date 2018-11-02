package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "pokemon")
public class Pokemon {
	@Id
	private String id;
	private String charId;
	private String userId;
	
	public String getCharId() {
		return charId;
	}
	public void setCharId(String charId) {
		this.charId = charId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Pokemon [charId=" + charId + ", userId=" + userId + ", id=" + id + "]";
	}
	public Pokemon(String charId, String userId, String id) {
		super();
		this.charId = charId;
		this.userId = userId;
		this.id = id;
	}
	
	
}
