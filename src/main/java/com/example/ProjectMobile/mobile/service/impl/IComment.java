package com.example.ProjectMobile.mobile.service.impl;

import java.util.List;

import com.example.ProjectMobile.mobile.model.Comment;


public interface IComment {
	List<Comment> getAllComments();
	Comment findById(long id);
	Comment findByUserId(long id);
	List<Comment> findByPostId(long id);
	Comment save(Comment comment);
	void deleteById(long id);
	List<Comment> findCommentsByPostOwner(long id);
}
