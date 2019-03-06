package com.hoangnt.service;

import java.util.List;

import com.hoangnt.model.QuanHuyenDTO;
import com.hoangnt.model.TinhThanhPhoDTO;
import com.hoangnt.model.UserDTO;
import com.hoangnt.model.XaPhuongThiTranDTO;

public interface UserService {
	void addUserDTO(UserDTO userDTO);

	UserDTO getUserById(int id);

	UserDTO getUserByNameAccount(String name);

	void updateUserDTO(UserDTO userDTO);

	void deleteUser(int id);

	List<UserDTO> getAllUser();

}
