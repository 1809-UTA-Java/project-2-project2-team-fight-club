package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "pokemon")
public class Pokemon {
	private String charId;
	private String userId;
	
	public String getCharId() {
		return charId;
	}
	public void setCharId(String charId) {
		this.charId = charId;
	}
	@Override
	public String toString() {
		return "Pokemon [charId=" + charId + ", userId=" + userId + "]";
	}
	public Pokemon(String charId, String userId) {
		super();
		this.charId = charId;
		this.userId = userId;
	}
	
}
