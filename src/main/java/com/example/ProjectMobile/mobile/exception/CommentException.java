package com.example.ProjectMobile.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ProjectMobile.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommentException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public CommentException(String code, HttpStatus status) {
		super("comment."+code, status);
	}
	public static CommentException emptyComment() {
		return new CommentException("findComment.notFound", HttpStatus.BAD_REQUEST);
	}
}
