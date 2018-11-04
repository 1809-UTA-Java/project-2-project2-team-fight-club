package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "pokemon")
public class Pokemon {
	@Id
	@Column (name = "id")
	private String id;
	@Column (name = "charid")
	private String charId;
	@Column (name = "userid")
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
}
