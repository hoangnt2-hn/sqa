package com.hoangnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoangnt.model.AccountDTO;
import com.hoangnt.model.UserDTO;
import com.hoangnt.service.UserService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody AccountDTO accountDTO) {
		return new ResponseEntity<UserDTO>(userService.login(accountDTO.getUsername(), accountDTO.getPassword()),
				HttpStatus.OK);
	}

	@PostMapping("/users/register")
	public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO) {
		if (userService.getUserByNameAccount(userDTO.getAccountDTO().getUsername()).equals(null)) {
			userService.addUserDTO(userDTO);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
		return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
	}

	@GetMapping("/users/name/{name}")
	public ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
		return new ResponseEntity<UserDTO>(userService.getUserByNameAccount(name), HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		return new ResponseEntity<List<UserDTO>>(userService.getAllUser(), HttpStatus.OK);
	}

	@PatchMapping("/users/update")
	public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO) {
		userService.updateUserDTO(userDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("users/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
