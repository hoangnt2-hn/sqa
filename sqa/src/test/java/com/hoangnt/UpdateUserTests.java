package com.hoangnt;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoangnt.entity.User;
import com.hoangnt.model.AddressDTO;
import com.hoangnt.model.QuanHuyenDTO;
import com.hoangnt.model.SalaryDTO;
import com.hoangnt.model.TinhThanhPhoDTO;
import com.hoangnt.model.UserDTO;
import com.hoangnt.model.XaPhuongThiTranDTO;
import com.hoangnt.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UpdateUserTests {
	@Autowired
	UserService userService;

	// cap nhat doi tuong User
	public boolean updateUser(int id, String full_name, String email, String id_person, String date_of_birth,
			boolean is_male, boolean is_vol, String career, boolean is_free, String free_detail, String phone,
			int role_id, String matp, String maqh, String xaid, Double main_sal, Double position_allowrance,
			Double res_allowrance) {
		UserDTO userDTO = new UserDTO(); // tao 1 doi tuong user moi
		userDTO.setId(id);
		userDTO.setFull_name(full_name);
		userDTO.setEmail(email);
		userDTO.setId_person(id_person);
		userDTO.setDate_of_birth(date_of_birth);
		userDTO.setIs_male(is_male);
		userDTO.setIs_vol(is_vol);
		userDTO.setCareer(career);
		userDTO.setIs_free(is_free);
		userDTO.setFree_detail(free_detail);
		userDTO.setPhone(phone);
		userDTO.setRole_id(role_id);

		AddressDTO addressDTO = new AddressDTO();

		TinhThanhPhoDTO tinhThanhPhoDTO = new TinhThanhPhoDTO(matp);
		QuanHuyenDTO quanHuyenDTO = new QuanHuyenDTO(maqh);
		XaPhuongThiTranDTO xaPhuongThiTranDTO = new XaPhuongThiTranDTO(xaid);

		addressDTO.setProvince(tinhThanhPhoDTO);
		addressDTO.setDistrict(quanHuyenDTO);
		addressDTO.setTown(xaPhuongThiTranDTO);

		userDTO.setAddressDTO(addressDTO);

		SalaryDTO salaryDTO = new SalaryDTO();
		salaryDTO.setMain_sal(main_sal);
		salaryDTO.setPosition_allowrance(position_allowrance);
		salaryDTO.setRes_allowrance(res_allowrance);

		userDTO.setSalaryDTO(salaryDTO);
		User user = userService.updateUserDTO(userDTO);

		if (user.getFull_name().equals("Nguyễn Trí Hoàngggggg")) { // neu doi tuong user duoc update co ten giong
																	// voi ten yeu cau duoc cap nhat
			return true;
		}
		return false;

	}

	@Test
	public void contextLoads() {

		assertEquals(true,
				updateUser(11, "Nguyễn Trí Hoàngggggg", "gdfgdf@gmail.com", "111111111111", "1997-02-22", true, false,
						"Dev", false, "NO", "0903111231", 3, "01", "001", "00001", 10000000.0, 1000000.0, 1000000.0));

	}
}
