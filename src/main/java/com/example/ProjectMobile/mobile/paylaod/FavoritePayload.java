package com.example.ProjectMobile.mobile.paylaod;

import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FavoritePayload {
	private User user;
	private Post post;
}
