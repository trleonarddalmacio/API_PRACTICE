package com.leodalmacio.usersapi.userUsingORM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
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
	
	public List<User> searchUser(String search ) {
		return userRepository.findByFNameContainingOrLNameContainingOrEmailContainingOrAddressContaining(search, search, search, search);
	}
}
