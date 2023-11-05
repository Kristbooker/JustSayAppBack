package com.example.ProjectMobile.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ProjectMobile.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public PostException(String code, HttpStatus status) {
		super("Post."+code,status);
	}
	public static PostException emptyPost() {
		return new PostException("findPost.notFound", HttpStatus.BAD_REQUEST);
	}
}
