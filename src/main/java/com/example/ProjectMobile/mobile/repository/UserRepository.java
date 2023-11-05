package com.example.ProjectMobile.mobile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectMobile.mobile.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findById(long id);
	User findByUserName(String userName);
	Optional<User> findOptionalById(long id);
}
