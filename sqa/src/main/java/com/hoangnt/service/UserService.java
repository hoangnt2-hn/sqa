package com.hoangnt.service;

import java.util.List;

import com.hoangnt.entity.User;
import com.hoangnt.model.AccountDTO;
import com.hoangnt.model.UserDTO;

public interface UserService {
	User addUserDTO(UserDTO userDTO);

	UserDTO getUserById(int id);

	UserDTO getUserByNameAccount(String name);

	UserDTO getUserByEmail(String email);
	
	UserDTO login(AccountDTO accountDTO);

	User updateUserDTO(UserDTO userDTO);

	void deleteUser(int id);

	List<UserDTO> getAllUser();

	void updatePassword(String password, int id);
	
	

}
