package com.revature.controller;

import org.springframework.stereotype.Controller;

import com.revature.entity.User;

@Controller
public class UserController {

	User newUser = new User();

	public void setUser(String id, String name) {
		newUser.setId(id);
		newUser.setName(name);
	}

	public User getUser() {
		return newUser;
	}

}
