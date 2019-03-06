package com.hoangnt.controller;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) {                     //Ktra thong tin dang nhap
		UserDTO userDTO = userService.getUserByNameAccount(accountDTO.getUsername());
		if (userDTO != null && BCrypt.checkpw(accountDTO.getPassword(), userDTO.getAccountDTO().getPassword())) { //check password

			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/users/register")
	public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO){						//them user
		if (userService.getUserByNameAccount(userDTO.getAccountDTO().getUsername()) == null) {//check usernam da ton tai chua 
			userService.addUserDTO(userDTO);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	@PatchMapping("/users/update")
	public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO) {					//update user
		if (userService.getUserByNameAccount(userDTO.getAccountDTO().getUsername()) == null) { //check usernam da ton tai chua 
			userService.updateUserDTO(userDTO);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("users/delete/{id}")			
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {							//xoa user
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {							//lay user theo id
		if (userService.getUserById(id) != null) {
			return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/users/name/{name}")
	public ResponseEntity<?> getUserByName(@PathVariable String name) {						//lay user theo name
		if (userService.getUserByNameAccount(name) != null) {								//check name co ton tai khong
			return new ResponseEntity<UserDTO>(userService.getUserByNameAccount(name), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUser() {										//lay tat ca user
		return new ResponseEntity<List<UserDTO>>(userService.getAllUser(), HttpStatus.OK);
	}

}
