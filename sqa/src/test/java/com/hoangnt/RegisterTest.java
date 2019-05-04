package com.hoangnt;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoangnt.model.AddressDTO;
import com.hoangnt.model.QuanHuyenDTO;
import com.hoangnt.model.SalaryDTO;
import com.hoangnt.model.TinhThanhPhoDTO;
import com.hoangnt.model.UserDTO;
import com.hoangnt.model.XaPhuongThiTranDTO;
import com.hoangnt.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterTest {

	@Autowired
	UserService userService;
	List<UserDTO> userDTOs = new ArrayList<>();

//	@Before
//	public void midleware() throws IOException {
//		FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\abc\\Desktop\\RegisterTest.xlsx"));
//
//		Workbook workbook = new XSSFWorkbook(excelFile);
//		Sheet datatypeSheet = workbook.getSheetAt(0);
//		Iterator<Row> iterator = datatypeSheet.iterator();
//		Row firstRow = iterator.next();
//		Cell firstCell = firstRow.getCell(0);
//		firstCell.getStringCellValue();
//		while (iterator.hasNext()) {
//			Row currentRow = iterator.next();
//			UserDTO userDTO = new UserDTO();
//			userDTO.setFull_name(currentRow.getCell(0).getStringCellValue());
//			userDTO.setEmail(currentRow.getCell(1).getStringCellValue());
//			userDTO.setId_person(currentRow.getCell(2).getStringCellValue());
//			userDTO.setDate_of_birth(currentRow.getCell(3).getStringCellValue());
//			userDTO.setIs_male(Boolean.parseBoolean(currentRow.getCell(4).getStringCellValue()));
//			userDTO.setIs_vol(Boolean.parseBoolean(currentRow.getCell(5).getStringCellValue()));
//			userDTO.setCareer(currentRow.getCell(6).getStringCellValue());
//			userDTO.setIs_free(Boolean.parseBoolean(currentRow.getCell(7).getStringCellValue()));
//			userDTO.setFree_detail(currentRow.getCell(8).getStringCellValue());
//			userDTO.setPhone(currentRow.getCell(9).getStringCellValue());
//			userDTO.setRole_id(Integer.parseInt(currentRow.getCell(10).getStringCellValue()));
//
//			AddressDTO addressDTO = new AddressDTO();
//
//			TinhThanhPhoDTO tinhThanhPhoDTO = new TinhThanhPhoDTO(currentRow.getCell(11).getStringCellValue());
//			QuanHuyenDTO quanHuyenDTO = new QuanHuyenDTO(currentRow.getCell(12).getStringCellValue());
//			XaPhuongThiTranDTO xaPhuongThiTranDTO = new XaPhuongThiTranDTO(currentRow.getCell(13).getStringCellValue());
//
//			addressDTO.setProvince(tinhThanhPhoDTO);
//			addressDTO.setDistrict(quanHuyenDTO);
//			addressDTO.setTown(xaPhuongThiTranDTO);
//
//			userDTO.setAddressDTO(addressDTO);
//
//			SalaryDTO salaryDTO = new SalaryDTO();
//			salaryDTO.setMain_sal(Double.parseDouble(currentRow.getCell(14).getStringCellValue()));
//			salaryDTO.setPosition_allowrance(Double.parseDouble(currentRow.getCell(15).getStringCellValue()));
//			salaryDTO.setRes_allowrance(Double.parseDouble(currentRow.getCell(16).getStringCellValue()));
//
//			userDTO.setSalaryDTO(salaryDTO);
//			userDTOs.add(userDTO);
//		}
//		workbook.close();
//	}
//
//	public boolean addUserExcel(UserDTO userDTO) {
//
//		userService.addUserDTO(userDTO);
//		if (userService.getUserByEmail(userDTO.getEmail()) != null) {
//			userService.deleteUser(userService.getUserByEmail(userDTO.getEmail()).getId());
//			return true;
//		}
//
//		return false;
//
//	}

	public boolean addUser(String full_name, String email, String id_person, String date_of_birth, boolean is_male,
			boolean is_vol, String career, boolean is_free, String free_detail, String phone, int role_id, String matp,
			String maqh, String xaid, Double main_sal, Double position_allowrance, Double res_allowrance) {
		UserDTO userDTO = new UserDTO();
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
		if (userService.addUserDTO(userDTO) != null) {
			userService.deleteUser(userService.getUserByEmail(email).getId());
			return true;
		}
		return false;

	}

	@Test
	public void contextLoads() throws IOException {

		assertEquals(true, addUser("Nguyễn Trí Hoàng", "hoangnt.working@gmail.com", "111111111111", "1997-02-22", true,
				false, "Dev", false, "NO", "0903111231", 3, "01", "001", "00001", 10000000.0, 1000000.0, 1000000.0));

	}

	@Test
	public void contextLoads1() throws IOException {

		assertEquals(true, addUser("Nguyễn Trí Hoàng", "trihoangdeptrai@gmail.com", "111111111111", "1997-02-22", true,
				false, "Dev", false, "NO", "0903111231", 3, "01", "001", "00001", 10000000.0, 1000000.0, 1000000.0));

	}
}
