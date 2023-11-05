package com.example.ProjectMobile.mobile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ProjectMobile.mobile.model.Like;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.repository.LikeRepository;
import com.example.ProjectMobile.mobile.repository.PostRepository;
import com.example.ProjectMobile.mobile.service.impl.ILike;


@Service
public class LikeService implements ILike{
	@Autowired
	LikeRepository likeRepository;
	@Autowired
	PostRepository postRepository;
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	@Override
	public List<Like> getAllLikeds() {
		return likeRepository.findAll();
	}

	@Override
	public Like findById(long id) {
		return likeRepository.findById(id);
	}

	@Override
	public Like findByUserId(long id) {
		return likeRepository.findByUserId(id);
	}

	@Override
	public List<Like> findByPostId(long id) {
		return likeRepository.findByPostId(id);
	}

	@Override
	public Like save(Like liked) {
		return likeRepository.save(liked);
	}

	@Override
	public void deleteById(long id) {
		likeRepository.deleteById(id);
		
	}
	
	public Optional<Like> findOptionalById(long id){
		return likeRepository.findOptionalById(id);
	}
	@Override
	public List<Like> findLikesByPostOwner(long id) {
		// TODO Auto-generated method stub
		List<Post> posts = postRepository.findByUserId(id);
        List<Like> likes = new ArrayList<>();
        for (Post post : posts) {
            // Assuming you have a method in CommentRepository to find comments by postId
            likes.addAll(likeRepository.findByPostId(post.getId()));
        }
        return likes;
	}
}
