package com.example.ProjectMobile.mobile.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.json.PostListJson;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.paylaod.PostPayload;
import com.example.ProjectMobile.mobile.service.PostService;



@Service
public class PostBusiness {
	@Autowired
	PostService postService;
	
	public List<PostListJson> getListPost(){
		return PostListJson.packJsons(postService.getAllPosts());
	}
	public List<PostListJson> getPostByUserId(long id) {
		return PostListJson.packJsons(postService.findByUserId(id));
	}

	public void savePost(PostPayload postPayload) {
		Post post = new Post(
					postPayload.getUser(),
					postPayload.getContent());
		postService.save(post);
	}
	
	public void updatePost(long id, PostPayload postPayload) {
		Post postData = postService.findById(id);
		postData.setUser(postPayload.getUser());
		postData.setContent(postPayload.getContent());
		postService.save(postData);
	}
	
	public void deletePost(long id) {
		postService.deleteById(id);
	}
	
}
