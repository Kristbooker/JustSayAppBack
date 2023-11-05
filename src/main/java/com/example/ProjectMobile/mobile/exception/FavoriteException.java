package com.example.ProjectMobile.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ProjectMobile.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter 
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FavoriteException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public FavoriteException(String code, HttpStatus status) {
		super("favorite."+code, status);
	}
	
	public static FavoriteException emptyFavorite() {
		return new FavoriteException("findFavorite.notFound", HttpStatus.BAD_REQUEST);
	}

}
