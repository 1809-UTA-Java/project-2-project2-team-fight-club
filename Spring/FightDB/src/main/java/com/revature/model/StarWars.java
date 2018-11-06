package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "sw")
public class StarWars {
	@Id
	private String id;
	@Column (name = "userid")
	private String userId;
	@Column (name = "charid")
	private String charId;
	@Column (name = "battlerank")
	private int battleRank;
	@Column (name = "name")
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public int getBattleRank() {
		return battleRank;
	}
	public void setBattleRank(int battleRank) {
		this.battleRank = battleRank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StarWars [id=" + id + ", userId=" + userId + ", charId=" + charId + ", battleRank=" + battleRank
				+ ", name=" + name + "]";
	}
	
	
}
