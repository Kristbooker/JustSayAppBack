package com.example.ProjectMobile.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectMobile.mobile.model.Post;



public interface PostRepository extends JpaRepository<Post, Long>{
	Post findById(long id);
	List<Post> findByUserId(long id);
	Optional<Post> findOptionalById(long id);
}
