package com.revature.RandomUserAPI.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.RandomUserAPI.model.Id;
import com.revature.RandomUserAPI.model.User;

@RestController
public class UserController {
	@RequestMapping("/get")
	public User getUser() {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("https://randomuser.me/api/?inc=name,id", User.class);
		
		if (user.getResults()[0].getId().getValue() == null || user.getResults()[0].getId().getValue().isEmpty()) {
			Id id = new Id();
			id.setName("");
			id.setValue(UUID.randomUUID().toString());
			user.getResults()[0].setId(id);
		}
		
		return user;
	}
}
