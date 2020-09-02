package com.NHSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NHSystem.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findUserByEmail(String email);
	List<User> findUserByNameLike(String name);

}
