package com.example.ProjectMobile.mobile.json;

import java.util.ArrayList;
import java.util.List;

import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserListJson {
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String bio;
	private String proImg;
	
	public static UserListJson packJson(User user) {
		UserListJson ulj = new UserListJson();
		ulj.setId(user.getId());
		ulj.setUserName(user.getUserName());
		ulj.setFirstName(user.getFirstName());
		ulj.setLastName(user.getLastName());
		ulj.setPassword(user.getPassword());
		ulj.setBio(user.getBio());
		ulj.setProImg(user.getProImg());
		
		return ulj;
	}
	
	public static List<UserListJson> packJsons(List<User> users){
		List<UserListJson> userListJson = new ArrayList<UserListJson>();
		for (User user : users) {
			userListJson.add(packJson(user));
		}
		return userListJson;
	}
}
