package com.example.ProjectMobile.mobile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProjectMobile.exception.BaseException;
import com.example.ProjectMobile.mobile.business.CommentBusiness;
import com.example.ProjectMobile.mobile.json.CommentListJson;
import com.example.ProjectMobile.mobile.model.Comment;
import com.example.ProjectMobile.mobile.paylaod.CommentPayload;
import com.example.ProjectMobile.mobile.service.CommentService;

@Controller
@RequestMapping("api/comments")
public class CommentController {
	@Autowired
	CommentService commentService;
	@Autowired
	CommentBusiness commentBusiness;
	
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<CommentListJson>> getAllComments() throws BaseException{
		return ResponseEntity.ok(commentBusiness.getListComment());
	} 
	
	@GetMapping(value = "/post/{postId}")
	public ResponseEntity<List<CommentListJson>> getCommentByPostId(@PathVariable("postId") long id) throws BaseException{
		return ResponseEntity.ok(commentBusiness.getCommentByPostId(id));
	}
	@GetMapping("/ownerUserId/{userId}")
    public ResponseEntity<List<CommentListJson>> getCommentsByPostOwner(@PathVariable Long userId) {
        List<Comment> comments = commentService.findCommentsByPostOwner(userId);
        List<CommentListJson> commentsJson = CommentListJson.packJsons(comments);
        return new ResponseEntity<>(commentsJson, HttpStatus.OK);
    }
	@PostMapping(value = "/save")
	public ResponseEntity<Void> saveComment(@RequestBody CommentPayload commentPayload) throws BaseException{
		commentBusiness.saveComment(commentPayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<CommentListJson> updateComment(@PathVariable("id") long id,
			@RequestBody CommentPayload commentPayload){
		Optional<Comment> commentData = commentService.findOptionalById(id);
		if(commentData.isPresent()) {
			commentBusiness.updateComment(commentData.get().getId(),commentPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id){
		try {
			commentBusiness.deleteComment(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}

}
