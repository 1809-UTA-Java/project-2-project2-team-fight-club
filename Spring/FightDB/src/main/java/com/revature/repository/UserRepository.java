package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Query(value="SELECT * FROM (SELECT * FROM USERS ORDER BY dbms_random.value) WHERE rownum = 1", nativeQuery = true)
	List<User> findUsers();
}