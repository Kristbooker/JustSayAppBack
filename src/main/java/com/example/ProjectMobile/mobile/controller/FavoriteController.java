package com.example.ProjectMobile.mobile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProjectMobile.exception.BaseException;
import com.example.ProjectMobile.mobile.business.FavoriteBusiness;
import com.example.ProjectMobile.mobile.json.FavoriteListJson;
import com.example.ProjectMobile.mobile.model.Favorite;
import com.example.ProjectMobile.mobile.paylaod.FavoritePayload;
import com.example.ProjectMobile.mobile.service.FavoriteService;

@Controller
@RequestMapping("api/favorites")
public class FavoriteController {
	@Autowired
	FavoriteService favoriteService;
	@Autowired
	FavoriteBusiness favoriteBusiness;
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<FavoriteListJson>> getAllFavorites() throws BaseException{
		return ResponseEntity.ok(favoriteBusiness.getListFavorite());
	} 
	@GetMapping("/getFavByUser/{userId}")
	public ResponseEntity<List<FavoriteListJson>> getFavoriteByUserId(@PathVariable("userId") long id) throws BaseException{
		return ResponseEntity.ok(favoriteBusiness.getFavoriteByUserId(id));
	}
	@PostMapping(value = "/save")
	public ResponseEntity<Void> saveFavorite(@RequestBody FavoritePayload favoritePayload) throws BaseException{
		favoriteBusiness.saveFavorite(favoritePayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<FavoriteListJson> updateFavorite(@PathVariable("id") long id,
			@RequestBody FavoritePayload favoritePayload){
		Optional<Favorite> favoriteData = favoriteService.findOptionalById(id);
		if(favoriteData.isPresent()) {
			favoriteBusiness.updateFavorite(favoriteData.get().getId(),favoritePayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFavorite(@PathVariable("id") long id){
		try {
			favoriteBusiness.deleteFavorite(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}
}
