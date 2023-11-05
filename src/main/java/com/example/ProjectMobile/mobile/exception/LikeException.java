package com.example.ProjectMobile.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ProjectMobile.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LikeException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public LikeException(String code, HttpStatus status) {
		super("like."+code,status);
	}
	
	public static LikeException emptyLike() {
		return new LikeException("findLike.notFound", HttpStatus.BAD_REQUEST);
	}
}
