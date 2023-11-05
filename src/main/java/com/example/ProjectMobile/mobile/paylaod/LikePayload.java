package com.example.ProjectMobile.mobile.paylaod;

import java.time.LocalDateTime;

import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LikePayload {
	private User user;
	private Post post;
	private LocalDateTime time;
}
