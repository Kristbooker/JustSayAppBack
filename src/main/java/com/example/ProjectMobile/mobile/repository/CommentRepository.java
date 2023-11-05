package com.example.ProjectMobile.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectMobile.mobile.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{
	Comment findById(long id);
	Comment findByUserId(long id);
	List<Comment> findByPostId(long id);
	Optional<Comment> findOptionalById(long id);
 }
