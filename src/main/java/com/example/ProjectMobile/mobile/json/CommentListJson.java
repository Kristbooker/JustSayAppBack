package com.example.ProjectMobile.mobile.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.ProjectMobile.mobile.model.Comment;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentListJson {
	private long id;
	private User user;
	private Post post;
	private String content;
	private LocalDateTime time;
	
	public static CommentListJson packJson(Comment comment) {
		CommentListJson clj = new CommentListJson();
		clj.setId(comment.getId());
		clj.setUser(comment.getUser());
		clj.setPost(comment.getPost());
		clj.setContent(comment.getContent());
		clj.setTime(comment.getTime());
		
		return clj;
	}
	
	public static List<CommentListJson> packJsons(List<Comment> comments){
		List<CommentListJson> clj = new ArrayList<CommentListJson>();
		for (Comment comment : comments) {
			clj.add(packJson(comment));
		}
		return clj;
				
	}
}
