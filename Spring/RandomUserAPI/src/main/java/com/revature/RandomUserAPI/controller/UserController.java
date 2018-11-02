package com.revature.RandomUserAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.RandomUserAPI.model.User;

@RestController
public class UserController {
	@RequestMapping("/get")
	public User getUser() {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("https://randomuser.me/api/?inc=name,id", User.class);
		
		System.out.println("getUser()");
		System.out.println(user.getResults()[0].getName().getFirst());
		
		return user;
	}
}
