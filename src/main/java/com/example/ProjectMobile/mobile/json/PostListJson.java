package com.example.ProjectMobile.mobile.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostListJson {
	private long id;
	private User user;
	private String content;
	private String color;
	private LocalDateTime time;
	
	public static PostListJson packJson(Post post) {
		PostListJson plj = new PostListJson();
		plj.setId(post.getId());
		plj.setUser(post.getUser());
		plj.setContent(post.getContent());
		plj.setTime(post.getTime());
		
		return plj;
	}
	
	public static List<PostListJson> packJsons(List<Post> posts){
		List<PostListJson> plj = new ArrayList<PostListJson>();
		for (Post post : posts) {
			plj.add(packJson(post));
		}
		return plj;
	}
}
