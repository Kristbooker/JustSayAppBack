package com.example.ProjectMobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.repository.PostRepository;
import com.example.ProjectMobile.mobile.service.impl.IPost;


@Service
public class PostService implements IPost{
	@Autowired
	PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return postRepository.findById(id);
	}

	@Override
	public List<Post> findByUserId(long id) {
		return postRepository.findByUserId(id);
	}


	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void deleteById(long id) {
		postRepository.deleteById(id);
	}
	
	public Optional<Post> findOptionalById(long id){
		return postRepository.findOptionalById(id);
	}
}
