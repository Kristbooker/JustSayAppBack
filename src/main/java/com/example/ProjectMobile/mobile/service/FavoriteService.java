package com.example.ProjectMobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.model.Favorite;
import com.example.ProjectMobile.mobile.repository.FavoriteRepository;
import com.example.ProjectMobile.mobile.service.impl.IFavorite;

@Service
public class FavoriteService implements IFavorite{
	@Autowired
	FavoriteRepository favoriteRepository;
	public FavoriteService (FavoriteRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository;
	}
	
	@Override
	public List<Favorite> getAllFavorites() {
		// TODO Auto-generated method stub
		return favoriteRepository.findAll();
	}

	@Override
	public Favorite findById(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findById(id);
	}

	@Override
	public List<Favorite> findByUserId(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findByUserId(id);
	}

	@Override
	public Favorite findByPostId(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findByPostId(id);
	}

	@Override
	public Favorite save(Favorite favorite) {
		// TODO Auto-generated method stub
		return favoriteRepository.save(favorite);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		favoriteRepository.deleteById(id);
		
	}
	public Optional<Favorite> findOptionalById(long id){
		return favoriteRepository.findOptionalById(id);
	}

}
