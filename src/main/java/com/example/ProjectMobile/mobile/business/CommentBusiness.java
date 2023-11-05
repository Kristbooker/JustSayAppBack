package com.example.ProjectMobile.mobile.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.json.CommentListJson;
import com.example.ProjectMobile.mobile.model.Comment;
import com.example.ProjectMobile.mobile.paylaod.CommentPayload;
import com.example.ProjectMobile.mobile.service.CommentService;



@Service
public class CommentBusiness {
	@Autowired
	CommentService commentService;
	
	public List<CommentListJson> getListComment(){
		return CommentListJson.packJsons(commentService.getAllComments());
	}
	public CommentListJson getCommentByUserId(long id) {
		return CommentListJson.packJson(commentService.findByUserId(id));
	}
//	public CommentListJson getCommentByPostId(long id) {
//		return CommentListJson.packJson(commentService.findByPostId(id));
//	}
	public List<CommentListJson> getCommentByPostId(long id) {
		return CommentListJson.packJsons(commentService.findByPostId(id));
	}
	
	public void saveComment(CommentPayload commentPayload) {
		Comment comment = new Comment(
							commentPayload.getUser(),
							commentPayload.getPost(),
							commentPayload.getContent());
		commentService.save(comment);
	}
	
	public void updateComment(long id, CommentPayload commentPayload) {
		Comment commentData = commentService.findById(id);
		commentData.setUser(commentPayload.getUser());
		commentData.setPost(commentPayload.getPost());
		commentData.setContent(commentPayload.getContent());
		commentService.save(commentData);
	}
	
	public void deleteComment(long id) {
		commentService.deleteById(id);
	}
}
