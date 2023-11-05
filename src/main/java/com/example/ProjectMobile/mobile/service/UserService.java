package com.example.ProjectMobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.model.User;
import com.example.ProjectMobile.mobile.repository.UserRepository;
import com.example.ProjectMobile.mobile.service.impl.IUser;


@Service
public class UserService implements IUser{
	@Autowired
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
		
	}
	
	public Optional<User> findOptionalById(long id){
		return userRepository.findOptionalById(id);
	}

}
