package com.revature.starwars.component;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.revature.starwars.model.Person;

@Component
public class PersonComponent implements CommandLineRunner {

	Random rand = new Random();

	private static void callStarwarsApi() {

	}

	@Override
	public void run(String... arg0) throws Exception {
		callStarwarsApi();

	}

	public Person createPerson(String obj, String url) {
		String[] firstSplit = obj.split("=");
		String[] secondSplit = firstSplit[2].split(",");

		Person person = new Person(secondSplit[0], url);
		person.setBattleRank(this.random(10));

		return person;

	}

	public int random(int max) {
		int num = rand.nextInt(max) + 1;
		return num;

	}

}
