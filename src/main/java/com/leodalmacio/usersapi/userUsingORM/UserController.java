package com.leodalmacio.usersapi.userUsingORM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(@RequestParam(value="search", required=false) String search ) {
		return (search == null) ? userService.getAllUsers() : userService.searchUser(search);
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
