package com.example.ProjectMobile.mobile.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.json.FavoriteListJson;
import com.example.ProjectMobile.mobile.model.Favorite;
import com.example.ProjectMobile.mobile.paylaod.FavoritePayload;
import com.example.ProjectMobile.mobile.service.FavoriteService;

@Service
public class FavoriteBusiness {
	@Autowired
	FavoriteService favoriteService;
	public List<FavoriteListJson> getListFavorite(){
		return FavoriteListJson.packJsons(favoriteService.getAllFavorites());
	}
	
	public List<FavoriteListJson> getFavoriteByUserId(long id) {
		return FavoriteListJson.packJsons(favoriteService.findByUserId(id));
	}
	
	public FavoriteListJson getFavoriteByPostId(long id) {
		return FavoriteListJson.packJson(favoriteService.findByPostId(id));
	}
	
	public void saveFavorite(FavoritePayload favoritePayload) {
		Favorite favorite = new Favorite(
							favoritePayload.getUser(),
							favoritePayload.getPost());
		favoriteService.save(favorite);
	}
	
	public void updateFavorite(long id, FavoritePayload favoritePayload) {
		Favorite favoriteData = favoriteService.findById(id);
		favoriteData.setUser(favoritePayload.getUser());
		favoriteData.setPost(favoritePayload.getPost());
		favoriteService.save(favoriteData);
	}
	
	public void deleteFavorite(long id) {
		favoriteService.deleteById(id);
	}
}
