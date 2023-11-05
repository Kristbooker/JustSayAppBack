package com.example.ProjectMobile.mobile.service.impl;

import java.util.List;

import com.example.ProjectMobile.mobile.model.Post;


public interface IPost {
	List<Post> getAllPosts();
	Post findById(long id);
	List<Post> findByUserId(long id);
	Post save(Post post);
	void deleteById(long id);
}
