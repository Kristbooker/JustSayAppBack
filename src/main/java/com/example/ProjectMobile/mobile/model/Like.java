package com.example.ProjectMobile.mobile.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Liked")
@Table(name = "liked")
public class Like {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "likedID")
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "userID", referencedColumnName = "userID",nullable = false)
	    @Fetch(FetchMode.JOIN)
	    private User user;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "postID", referencedColumnName = "postID", nullable = false)
	    @Fetch (FetchMode.JOIN)
	    private Post post;

	    @CreationTimestamp
	    @Column(name = "time",nullable = false,
	    updatable = false, insertable = false,
	    columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    private LocalDateTime time;

	    public Like() {
	        ;
	    }

	    public Like(User user, Post post) {
	        super();
	        this.user = user;
	        this.post = post;
	    }

}
