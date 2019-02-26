package com.hoangnt.service;

import java.util.List;

import com.hoangnt.model.UserDTO;

public interface UserService {
	UserDTO login(String username, String password);
	
	void addUserDTO(UserDTO userDTO);
	
	UserDTO getUserById(int id);
	
	UserDTO getUserByNameAccount(String name);
	
	void updateUserDTO(UserDTO userDTO);

	void deleteUser(int id);
	
	List<UserDTO> getAllUser();
	
	
}
