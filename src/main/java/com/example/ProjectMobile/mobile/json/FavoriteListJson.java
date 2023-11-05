package com.example.ProjectMobile.mobile.json;

import java.util.ArrayList;
import java.util.List;

import com.example.ProjectMobile.mobile.model.Favorite;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter
@ToString
public class FavoriteListJson {
	private long id;
	private User user;
	private Post post;
	
	public static FavoriteListJson packJson(Favorite favorite) {
		
		FavoriteListJson flj = new FavoriteListJson();
		flj.setId(favorite.getId());
		flj.setUser(favorite.getUser());
		flj.setPost(favorite.getPost());
		
		return flj;
	}
	
	public static List<FavoriteListJson> packJsons(List<Favorite> favorites){
		List<FavoriteListJson> flj = new ArrayList<FavoriteListJson>();
		for(Favorite favorite : favorites) {
			flj.add(packJson(favorite));
		}
		return flj;
	}
}
