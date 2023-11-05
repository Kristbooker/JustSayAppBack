package com.example.ProjectMobile.mobile.service.impl;

import java.util.List;

import com.example.ProjectMobile.mobile.model.Favorite;

public interface IFavorite {
	List<Favorite> getAllFavorites();
	Favorite findById(long id);
	List<Favorite> findByUserId(long id);
	Favorite findByPostId(long id);
	Favorite save(Favorite favorite);
	void deleteById(long id);
}
