package com.example.ProjectMobile.mobile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.model.Comment;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.repository.CommentRepository;
import com.example.ProjectMobile.mobile.repository.PostRepository;
import com.example.ProjectMobile.mobile.service.impl.IComment;


@Service
public class CommentService implements IComment{
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	PostRepository postRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	@Override
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	@Override
	public Comment findById(long id) {
		return commentRepository.findById(id);
	}

	@Override
	public Comment findByUserId(long id) {
		return commentRepository.findByUserId(id);
	}

	@Override
	public List<Comment> findByPostId(long id) {
		return commentRepository.findByPostId(id);
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void deleteById(long id) {
		commentRepository.deleteById(id);
	}
	
	public Optional<Comment> findOptionalById(long id){
		return commentRepository.findOptionalById(id);
	}
	
	@Override
	public List<Comment> findCommentsByPostOwner(long id) {
        List<Post> posts = postRepository.findByUserId(id);
        List<Comment> comments = new ArrayList<>();
        for (Post post : posts) {
            // Assuming you have a method in CommentRepository to find comments by postId
            comments.addAll(commentRepository.findByPostId(post.getId()));
        }
        return comments;
    }
}
