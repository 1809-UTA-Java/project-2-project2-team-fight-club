package com.revature.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.StarWars;

@Repository
public interface StarWarsRepository extends JpaRepository<StarWars, String> {
	List<StarWars> findByUserId(String id);
}
