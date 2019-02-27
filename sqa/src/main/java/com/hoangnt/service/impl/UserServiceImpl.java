package com.hoangnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangnt.entity.Account;
import com.hoangnt.entity.Address;
import com.hoangnt.entity.Area;
import com.hoangnt.entity.Role;
import com.hoangnt.entity.Salary;
import com.hoangnt.entity.User;
import com.hoangnt.model.AccountDTO;
import com.hoangnt.model.AddressDTO;
import com.hoangnt.model.SalaryDTO;
import com.hoangnt.model.UserDTO;
import com.hoangnt.repository.AccountRepository;
import com.hoangnt.repository.AddressRepository;
import com.hoangnt.repository.SalaryRepository;
import com.hoangnt.repository.UserRepository;
import com.hoangnt.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	SalaryRepository salaryRepository;

	@Override
	public UserDTO login(String username, String password) {
		User user = userRepository.login(username, password);
		if (user != null) {
			return middleware(user);
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		userRepository.findAll().forEach(user -> {
			userDTOs.add(middleware(user));
		});
		return userDTOs;
	}

	@Override
	public UserDTO getUserById(int id) {
		User user = userRepository.getOne(id);
		if (user != null) {
			return middleware(user);
		}
		return null;
	}

	@Override
	public void deleteUser(int id) {
//		User user = userRepository.getOne(id);
		userRepository.deleteById(id);
//		accountRepository.deleteById(user.getAccount().getId());
//		addressRepository.deleteById(user.getAddress().getId());
//		salaryRepository.deleteById(user.getSalary().getId());
	}

//	@Override
//	public UserDTO getUserByFull_name(String full_name) {
//		User user = userRepository.findByFull_name(full_name);
//		return middleware(user);
//	}

	@Override
	public UserDTO getUserByNameAccount(String name) {
		User user = userRepository.findByNameAccount(name);
		if (user != null) {
			return middleware(user);
		}
		return null;
	}

	@Override
	public void addUserDTO(UserDTO userDTO) {
		User user = new User();

		user.setFull_name(userDTO.getFull_name());

		user.setId_person(userDTO.getId_person());
		user.setDate_of_birth(userDTO.getDate_of_birth());
		user.setSex(userDTO.isSex());

		user.setIs_vol(userDTO.isIs_vol());
		user.setCarrer(userDTO.getCarrer());
		user.setFree(userDTO.isFree());
		user.setFree_detail(userDTO.getFree_detail());
		user.setPhone(userDTO.getPhone());

		Account account = new Account();
		account.setUsername(userDTO.getAccountDTO().getUsername());
		account.setPassword(userDTO.getAccountDTO().getPassword());
		accountRepository.save(account);
		user.setAccount(account);

		Address address = new Address();
		address.setDistrict(userDTO.getAddressDTO().getDistrict());
		address.setProvince(userDTO.getAddressDTO().getProvince());
		address.setTown(userDTO.getAddressDTO().getTown());
		addressRepository.save(address);
		user.setAddress(address);

		Salary salary = new Salary();
		salary.setMain_sal(userDTO.getSalaryDTO().getMain_sal());
		salary.setPosition_allowrance(userDTO.getSalaryDTO().getPosition_allowrance());
		salary.setRes_allowrance(userDTO.getSalaryDTO().getRes_allowrance());
		salaryRepository.save(salary);
		user.setSalary(salary);

		user.setArea(new Area(userDTO.getArea_id()));

		user.setRole(new Role(userDTO.getRole_id()));

		userRepository.save(user);
	}

	@Override
	public void updateUserDTO(UserDTO userDTO) {
		User user = userRepository.getOne(userDTO.getId());

		user.setFull_name(userDTO.getFull_name());

		user.setId_person(userDTO.getId_person());
		user.setDate_of_birth(userDTO.getDate_of_birth());
		user.setSex(userDTO.isSex());

		user.setIs_vol(userDTO.isIs_vol());
		user.setCarrer(userDTO.getCarrer());
		user.setFree(userDTO.isFree());
		user.setFree_detail(userDTO.getFree_detail());
		user.setPhone(userDTO.getPhone());

		Account account = user.getAccount();
		account.setUsername(userDTO.getAccountDTO().getUsername());
		account.setPassword(userDTO.getAccountDTO().getPassword());
		accountRepository.save(account);
		user.setAccount(account);

		Address address = user.getAddress();
		address.setDistrict(userDTO.getAddressDTO().getDistrict());
		address.setProvince(userDTO.getAddressDTO().getProvince());
		address.setTown(userDTO.getAddressDTO().getTown());
		addressRepository.save(address);
		user.setAddress(address);

		Salary salary = user.getSalary();
		salary.setMain_sal(userDTO.getSalaryDTO().getMain_sal());
		salary.setPosition_allowrance(userDTO.getSalaryDTO().getPosition_allowrance());
		salary.setRes_allowrance(userDTO.getSalaryDTO().getRes_allowrance());
		salaryRepository.save(salary);
		user.setSalary(salary);

		user.setRole(new Role(userDTO.getRole_id()));
		user.setArea(new Area(userDTO.getArea_id()));

		userRepository.save(user);

	}

	public UserDTO middleware(User user) {
		UserDTO userDTO = new UserDTO(0);
		if (user.getId() > 0) {

			userDTO.setId(user.getId());
			userDTO.setFull_name(user.getFull_name());

			userDTO.setId_person(user.getId_person());
			userDTO.setDate_of_birth(user.getDate_of_birth());
			userDTO.setSex(user.isSex());

			userDTO.setIs_vol(user.isIs_vol());
			userDTO.setCarrer(user.getCarrer());
			userDTO.setFree(user.isFree());
			userDTO.setFree_detail(user.getFree_detail());
			userDTO.setPhone(user.getPhone());

			userDTO.setRole_id(user.getRole().getId());
			userDTO.setArea_id(user.getArea().getId());

			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId(user.getAccount().getId());
			accountDTO.setUsername(user.getAccount().getUsername());
			accountDTO.setPassword(user.getAccount().getPassword());

			userDTO.setAccountDTO(accountDTO);

			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setId(user.getAddress().getId());
			addressDTO.setDistrict(user.getAddress().getDistrict());
			addressDTO.setProvince(user.getAddress().getProvince());
			addressDTO.setTown(user.getAddress().getTown());

			userDTO.setAddressDTO(addressDTO);

			SalaryDTO salaryDTO = new SalaryDTO();
			salaryDTO.setId(user.getSalary().getId());
			salaryDTO.setMain_sal(user.getSalary().getMain_sal());
			salaryDTO.setPosition_allowrance(user.getSalary().getPosition_allowrance());
			salaryDTO.setRes_allowrance(user.getSalary().getRes_allowrance());

			userDTO.setSalaryDTO(salaryDTO);

		}
		return userDTO;
	}

}
