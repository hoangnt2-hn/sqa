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

	@Before
	public void midleware() throws IOException {
		FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\abc\\Desktop\\RegisterTest.xlsx"));

		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		Row firstRow = iterator.next();
		Cell firstCell = firstRow.getCell(0);
		firstCell.getStringCellValue();
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			UserDTO userDTO = new UserDTO();
			userDTO.setFull_name(currentRow.getCell(0).getStringCellValue());
			userDTO.setEmail(currentRow.getCell(1).getStringCellValue());
			userDTO.setId_person(currentRow.getCell(2).getStringCellValue());
			userDTO.setDate_of_birth(currentRow.getCell(3).getStringCellValue());
			userDTO.setIs_male(Boolean.parseBoolean(currentRow.getCell(4).getStringCellValue()));
			userDTO.setIs_vol(Boolean.parseBoolean(currentRow.getCell(5).getStringCellValue()));
			userDTO.setCareer(currentRow.getCell(6).getStringCellValue());
			userDTO.setIs_free(Boolean.parseBoolean(currentRow.getCell(7).getStringCellValue()));
			userDTO.setFree_detail(currentRow.getCell(8).getStringCellValue());
			userDTO.setPhone(currentRow.getCell(9).getStringCellValue());
			userDTO.setRole_id(Integer.parseInt(currentRow.getCell(10).getStringCellValue()));

			AddressDTO addressDTO = new AddressDTO();

			TinhThanhPhoDTO tinhThanhPhoDTO = new TinhThanhPhoDTO(currentRow.getCell(11).getStringCellValue());
			QuanHuyenDTO quanHuyenDTO = new QuanHuyenDTO(currentRow.getCell(12).getStringCellValue());
			XaPhuongThiTranDTO xaPhuongThiTranDTO = new XaPhuongThiTranDTO(currentRow.getCell(13).getStringCellValue());

			addressDTO.setProvince(tinhThanhPhoDTO);
			addressDTO.setDistrict(quanHuyenDTO);
			addressDTO.setTown(xaPhuongThiTranDTO);

			userDTO.setAddressDTO(addressDTO);

			SalaryDTO salaryDTO = new SalaryDTO();
			salaryDTO.setMain_sal(Double.parseDouble(currentRow.getCell(14).getStringCellValue()));
			salaryDTO.setPosition_allowrance(Double.parseDouble(currentRow.getCell(15).getStringCellValue()));
			salaryDTO.setRes_allowrance(Double.parseDouble(currentRow.getCell(16).getStringCellValue()));

			userDTO.setSalaryDTO(salaryDTO);
			userDTOs.add(userDTO);
		}
		workbook.close();
	}

	public boolean addUserExcel(UserDTO userDTO) {

		userService.addUserDTO(userDTO);
		if (userService.getUserByEmail(userDTO.getEmail()) != null) {
			userService.deleteUser(userService.getUserByEmail(userDTO.getEmail()).getId());
			return true;
		}

		return false;

	}

	@Test
	public void contextLoads() throws IOException {

		assertEquals(true, addUserExcel(userDTOs.get(0)));

	}
	@Test
	public void contextLoads1() throws IOException {

		assertEquals(true, addUserExcel(userDTOs.get(1)));

	}
}
