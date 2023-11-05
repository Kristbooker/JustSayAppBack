package com.example.ProjectMobile.mobile.model;

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
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Favorite")
@Table(name = "favorite",  uniqueConstraints = {
        @UniqueConstraint(name = "UniquePostAndUser", columnNames = {"userID", "postID"})
})
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favID")
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", referencedColumnName = "userID",nullable = false)
    @Fetch(FetchMode.JOIN)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postID", referencedColumnName = "postID", nullable = false)
    @Fetch (FetchMode.JOIN)
    private Post post;
    
    public Favorite() {
    	;
    }
    public Favorite(User user,Post post) {
    	this.user = user;
        this.post = post;
    }
}
