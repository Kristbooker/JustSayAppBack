package com.example.ProjectMobile.mobile.paylaod;

import java.time.LocalDateTime;

import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostPayload {
	private User user;
	private String content;
	private LocalDateTime time;
}
