package com.hoangnt.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoangnt.entity.User;
import com.hoangnt.model.AccountDTO;
import com.hoangnt.model.ResetPasswordDTO;
import com.hoangnt.model.UserDTO;
import com.hoangnt.service.UserService;
import com.hoangnt.service.impl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UserController {
	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) { // Ktra thong tin dang nhap
		UserDTO userDTO = userService.getUserByNameAccount(accountDTO.getUsername());
		if (userDTO != null && BCrypt.checkpw(accountDTO.getPassword(), userDTO.getAccountDTO().getPassword())) { // check
																													// password

			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/users/register")
	public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO) throws MessagingException { // them user
		if (userService.getUserByEmail(userDTO.getEmail()) == null) {// check email da ton
																		// tai chua
			User user = userService.addUserDTO(userDTO);

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			String html = "<div>Username : " + user.getAccount().getUsername() + "</div></br><div>Password : "+ UserServiceImpl.chuanHoaDate(userDTO.getDate_of_birth()) + "</div></br><div>Please don't provide this information to anyone in any form !!!</div>";
			message.setContent(html, "text/html");
			helper.setTo(userDTO.getEmail());
			helper.setSubject("Login information for social insurance calculation service");
			this.javaMailSender.send(message);

			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	@PatchMapping("/users/update")
	public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO) { // update user
		if (userService.getUserByEmail(userDTO.getEmail()) == null) { // check email da ton
																		// tai chua
			userService.updateUserDTO(userDTO);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping("/users/update/password/{id}")
	public ResponseEntity<?> updatePassword(@RequestBody ResetPasswordDTO resetPasswordDTO, @PathVariable int id) {
		UserDTO userDTO = userService.getUserById(id);

		if (!(resetPasswordDTO.getNew_pass().equals(resetPasswordDTO.getOld_pass())) && userDTO != null && BCrypt.checkpw(resetPasswordDTO.getOld_pass(), userDTO.getAccountDTO().getPassword())) {
			userService.updatePassword(BCrypt.hashpw(resetPasswordDTO.getNew_pass(), BCrypt.gensalt(12)), id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("users/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) { // xoa user
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) { // lay user theo id
		if (userService.getUserById(id) != null) {
			return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/users/name/{name}")
	public ResponseEntity<?> getUserByName(@PathVariable String name) { // lay user theo name
		if (userService.getUserByNameAccount(name) != null) { // check name co ton tai khong
			return new ResponseEntity<UserDTO>(userService.getUserByNameAccount(name), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUser() { // lay tat ca user
		return new ResponseEntity<List<UserDTO>>(userService.getAllUser(), HttpStatus.OK);
	}
	

}
