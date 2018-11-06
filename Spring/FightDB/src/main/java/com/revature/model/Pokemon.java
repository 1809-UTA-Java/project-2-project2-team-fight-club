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
		return "Pokemon [id=" + id + ", charId=" + charId + ", userId=" + userId + ", battleRank=" + battleRank
				+ ", name=" + name + "]";
	}
	
}
