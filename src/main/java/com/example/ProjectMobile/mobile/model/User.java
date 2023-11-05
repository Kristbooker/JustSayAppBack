package com.example.ProjectMobile.mobile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_name_uq" , columnNames = "userName")
        }
)
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long id;

    @Column(name = "userName" , nullable = false,unique = true)
    private String userName;

    @Column(name = "first_name" , nullable = false)
    private String firstName;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "bio" , nullable = false)
    private String bio;

    @Column(name="profile_image",nullable = false )
    private String proImg;

    public User() {
        ;
    }

    public User(String userName,String firstName,String lastName,String password,String bio,String proImg){
        super();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.bio = bio;
        this.proImg = proImg;
    }
}