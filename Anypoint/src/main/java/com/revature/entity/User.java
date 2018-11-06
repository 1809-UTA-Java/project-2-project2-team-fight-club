package com.revature.entity;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.springframework.stereotype.Component;

@Component
public class User implements Callable{
	private String id;
	private String name;

	public User() {
		
	}

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

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		return null;
	}

}
