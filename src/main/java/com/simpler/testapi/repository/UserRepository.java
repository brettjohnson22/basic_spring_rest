package com.simpler.testapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpler.testapi.data.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
