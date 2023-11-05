package com.example.ProjectMobile.mobile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProjectMobile.exception.BaseException;
import com.example.ProjectMobile.mobile.business.LikeBusiness;
import com.example.ProjectMobile.mobile.json.LikeListJson;
import com.example.ProjectMobile.mobile.model.Like;
import com.example.ProjectMobile.mobile.paylaod.LikePayload;
import com.example.ProjectMobile.mobile.service.LikeService;

@Controller
@RequestMapping("api/liked/")
public class LikeController {
	@Autowired
	LikeBusiness likeBusiness;
	@Autowired
	LikeService likeService;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<LikeListJson>> getAllLikes() throws BaseException{
		return ResponseEntity.ok(likeBusiness.getListLike());
	} 
	
	@GetMapping(value = "/post/{postId}")
	public ResponseEntity<Integer> getLikeByPostId(@PathVariable("postId") long id) throws BaseException{
		 List<LikeListJson> likes = likeBusiness.getLikeByPostId(id);
		 return ResponseEntity.ok(likes.size());
	}
	
	@GetMapping("/ownerUserId/{userId}")
    public ResponseEntity<List<LikeListJson>> getLikesByPostOwner(@PathVariable Long userId) {
        List<Like> likes = likeService.findLikesByPostOwner(userId);
        List<LikeListJson> likesJson = LikeListJson.packJsons(likes);
        return new ResponseEntity<>(likesJson, HttpStatus.OK);
    }
	
	@PostMapping(value = "/save")
	public ResponseEntity<Void> saveLike(@RequestBody LikePayload likePayload) throws BaseException{
		likeBusiness.saveLike(likePayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<LikeListJson> updateLike(@PathVariable("id") long id,
			@RequestBody LikePayload likePayload){
		Optional<Like> likeData = likeService.findOptionalById(id);
		if(likeData.isPresent()) {
			likeBusiness.updateLike(likeData.get().getId(),likePayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteLike(@PathVariable("id") long id){
		try {
			likeBusiness.deleteLike(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}
	
}
