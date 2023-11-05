package com.example.ProjectMobile.mobile.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.json.UserListJson;
import com.example.ProjectMobile.mobile.model.User;
import com.example.ProjectMobile.mobile.paylaod.UserPayload;
import com.example.ProjectMobile.mobile.service.UserService;



@Service
public class UserBusiness {
	@Autowired 
	UserService userService;
	
	public List<UserListJson> getListUser(){
		return UserListJson.packJsons(userService.getAllUsers());
	}
	
	public UserListJson getUserId(long id) {
		return UserListJson.packJson(userService.findById(id));
	}
	
	public UserListJson getUserByUserName(String userName) {
		return UserListJson.packJson(userService.findByUserName(userName));
	}
	
	public void saveUser(UserPayload userPayload) {
		User user = new User(
					userPayload.getUserName(),
					userPayload.getFirstName(),
					userPayload.getLastName(),
					userPayload.getPassword(),
					userPayload.getBio(),
					userPayload.getProImg());
		userService.save(user);
	}
	
	public void updateUser(long id, UserPayload userPayload) {
		User userData = userService.findById(id);
		userData.setUserName(userPayload.getUserName());
		userData.setFirstName(userPayload.getFirstName());
		userData.setLastName(userPayload.getLastName());
		userData.setPassword(userPayload.getPassword());
		userData.setBio(userPayload.getBio());
		userData.setProImg(userPayload.getProImg());
		userService.save(userData);
	}
	
	public void deleteUser(long id) {
		userService.deleteById(id);
	}
}
