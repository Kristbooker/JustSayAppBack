package com.example.ProjectMobile.mobile.service.impl;

import java.util.List;


import com.example.ProjectMobile.mobile.model.Like;


public interface ILike {
	List<Like> getAllLikeds();
	Like findById(long id);
	Like findByUserId(long id);
	List<Like> findByPostId(long id);
	Like save(Like liked);
	void deleteById(long id);
	List<Like> findLikesByPostOwner(long id);
}
