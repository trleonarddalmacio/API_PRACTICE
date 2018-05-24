package com.leodalmacio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.leodalmacio.model.User;
import com.leodalmacio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers(PageRequest request) {
		return userRepository.findAll(request).getContent();
	}
	
	public User getUser(Long id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return userRepository.findOne(id);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.delete(id);
		
	}
	
	public List<User> searchUserByAll(String search, PageRequest request) {
		return userRepository.findByFNameContainingOrLNameContainingOrEmailContainingOrAddressContaining(search, search, search, search, request)
				.getContent();
	}
	
	public List<User> searchUserByFName(String fName, PageRequest request) {
		return userRepository.findByFNameContaining(fName, request)
				.getContent();
	}
	public List<User> searchUserByLName(String lName, PageRequest request) {
		return userRepository.findByLNameContaining(lName, request)
				.getContent();
	}
	public List<User> searchUserByEmail(String email, PageRequest request) {
		return userRepository.findByEmailContaining(email, request)
				.getContent();
	}
	public List<User> searchUserByAddress(String address, PageRequest request) {
		return userRepository.findByAddressContaining(address, request)
				.getContent();
	}
}
