package com.example.ProjectMobile.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectMobile.mobile.model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
	Favorite findById(long id);
	List<Favorite> findByUserId(long id);
	Favorite findByPostId(long id);
	Optional<Favorite> findOptionalById(long id);
}

