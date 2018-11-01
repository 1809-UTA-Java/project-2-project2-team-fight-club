package com.revature.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Pokemon;
import com.revature.model.User;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, String> {
	List<Pokemon> findByUserId(String id);
}