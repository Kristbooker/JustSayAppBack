package com.example.ProjectMobile.mobile.service.impl;

import java.util.List;

import com.example.ProjectMobile.mobile.model.User;

public interface IUser {
	List<User> getAllUsers();
	User findById(long id);
	User findByUserName(String userName);
	User save(User user);
	void deleteById(long id);

}
