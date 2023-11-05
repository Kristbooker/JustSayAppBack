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
import com.example.ProjectMobile.mobile.business.PostBusiness;
import com.example.ProjectMobile.mobile.json.PostListJson;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.paylaod.PostPayload;
import com.example.ProjectMobile.mobile.service.PostService;

@Controller
@RequestMapping("api/posts")
public class PostController {
	@Autowired
	PostService postService;
	@Autowired
	PostBusiness postBusiness;
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<PostListJson>> getAllPosts() throws BaseException{
		return ResponseEntity.ok(postBusiness.getListPost());
	} 
	
	@PostMapping(value = "/save")
	public ResponseEntity<Void> savePost(@RequestBody PostPayload postPayload) throws BaseException{
		postBusiness.savePost(postPayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<PostListJson> updatePost(@PathVariable("id") long id,
			@RequestBody PostPayload postPayload){
		Optional<Post> postData = postService.findOptionalById(id);
		if(postData.isPresent()) {
			postBusiness.updatePost(postData.get().getId(),postPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id){
		try {
			postBusiness.deletePost(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}
}
