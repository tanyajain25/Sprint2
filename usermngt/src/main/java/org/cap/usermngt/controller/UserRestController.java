package org.cap.usermngt.controller;

import org.cap.usermngt.dto.RequestUserDto;
import org.cap.usermngt.entities.User;
import org.cap.usermngt.exceptions.UserNotFoundException;
import org.cap.usermngt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated
public class UserRestController {

	@Autowired
	private UserService service;

	/* add new user */
	@PostMapping("/add")
	public ResponseEntity<User> addUsers(@RequestBody @Valid RequestUserDto requestData) {
		User user = convertFromDtoToUser(requestData);
		user = service.addUser(user);
		ResponseEntity<User> reponse = new ResponseEntity<User>(user, HttpStatus.OK);
		return reponse;
	}

	/* convert dtodetails to user */
	public User convertFromDtoToUser(RequestUserDto requestData) {
		User user = new User();
		user.setUserType(requestData.getUserType());
		user.setUserName(requestData.getUserName());
		user.setUserPassword(requestData.getUserPassword());
		user.setUserPhone(requestData.getUserPhone());
		user.setUserEmail(requestData.getUserEmail());
		return user;
	}

	/* get user by userId */
	@GetMapping("/getbyuserid/{userId}")
	public ResponseEntity<User> findByUserId(@PathVariable("userId") BigInteger userId) {
		User user = service.viewUser(userId);
		ResponseEntity<User> reponse = new ResponseEntity<User>(user, HttpStatus.OK);
		return reponse;
	}

	/* getall users */
	@GetMapping("/getall")
	public ResponseEntity<List<User>> fetchAllUsers() {
		List<User> listOfUsers = service.viewAllUsers();
		ResponseEntity<List<User>> reponse = new ResponseEntity<List<User>>(listOfUsers, HttpStatus.OK);
		return reponse;
	}

	/* delete user by userId */
	@DeleteMapping("/deletebyuserid/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") BigInteger userId) {
		boolean result=service.deleteUser(userId);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return reponse;
	}

	/* update user */
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User users = service.updateUser(user);
		ResponseEntity<User> response = new ResponseEntity<>(users, HttpStatus.OK);
		return response;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException exception) {
		String message = exception.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		return response;
	}

}
