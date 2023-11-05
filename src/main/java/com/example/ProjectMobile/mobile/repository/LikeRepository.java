package com.example.ProjectMobile.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectMobile.mobile.model.Like;



public interface LikeRepository extends JpaRepository<Like, Long>{
	Like findById(long id);
	Like findByUserId(long id);
	List<Like> findByPostId(long id);
	Optional<Like> findOptionalById(long id);
}
