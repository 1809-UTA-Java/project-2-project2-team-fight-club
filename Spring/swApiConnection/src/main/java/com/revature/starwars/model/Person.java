package com.revature.starwars.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	private UUID id;

	private String name;
	private int battleRank;
	private String url;

	public Person() {
		super();
	}

	public Person(String name, String url) {
		super();
		this.id = UUID.randomUUID();
		this.name = name;
		this.url = url;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBattleRank() {
		return battleRank;
	}

	public void setBattleRank(int battleRank) {
		this.battleRank = battleRank;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", battleRank=" + battleRank + ", url=" + url + "]";
	}

}
