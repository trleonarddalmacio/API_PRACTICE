package com.leodalmacio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leodalmacio.model.User;
import com.leodalmacio.service.UserService;

@RestController
public class UserController  {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(@RequestParam(value="search", required=false) String search,
								  @RequestParam(value="id", required=false) Long id,
								  @RequestParam(value="fName", required=false) String fName,
								  @RequestParam(value="lName", required=false) String lName,
								  @RequestParam(value="email", required=false) String email,
								  @RequestParam(value="address", required=false) String address,
								  @RequestParam(value="page", required=false) String page,
								  @RequestParam(value="itemPerPage", required=false) String itemPerPage,
								  @RequestParam(value="orderBy", required=false) String orderBy,
								  @RequestParam(value="sortDirection", required=false) String sortDirection
								  ){
		List<User> getUsersToSend;
		List<User> usersToSend;
		
		PageRequest request;
		Direction direction;
		if (sortDirection.equals("ASC")) {
			direction = Sort.Direction.ASC;
		} else{
			direction = Sort.Direction.DESC;
		}
		request = new PageRequest(Integer.parseInt(page)-1, Integer.parseInt(itemPerPage), direction, orderBy);
		
		//------------ GETTING DATAS -----------//
		if (search != null) {
			getUsersToSend = userService.searchUserByAll(search, request);
		}
		else if (fName != null) {
			getUsersToSend = userService.searchUserByFName(fName, request);
		}
		else if (lName != null) {
			getUsersToSend = userService.searchUserByLName(lName, request);
		}
		else if (email != null) {
			getUsersToSend = userService.searchUserByEmail(email, request);
		}
		else if (address != null) {
			getUsersToSend = userService.searchUserByAddress(address, request);
		}
		else {
			getUsersToSend = userService.getAllUsers(request);
		}
		return getUsersToSend;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable Long id){
		return userService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateCourse(@RequestBody User user, @PathVariable Long id) {
		user.setId(id);
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteCourse(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
}
