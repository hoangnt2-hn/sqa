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

import com.hoangnt.model.AccountDTO;
import com.hoangnt.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTests {

	@Autowired
	UserService userService;

	List<AccountDTO> accountDTOs = new ArrayList<>();

	@Before
	public void midleware() throws IOException {
		FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\abc\\Desktop\\LoginTest.xlsx"));

		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		Row firstRow = iterator.next();
		Cell firstCell = firstRow.getCell(0);
		firstCell.getStringCellValue();
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setUsername(currentRow.getCell(0).getStringCellValue());
			accountDTO.setPassword(currentRow.getCell(1).getStringCellValue());
			accountDTOs.add(accountDTO);
		}
		workbook.close();
	}

	public boolean login(AccountDTO accountDTO) {

		if (userService.login(accountDTO) != null) {
			return true;
		}

		return false;
	}

	@Test
	public void contextLoads() {
		assertEquals(true, login(accountDTOs.get(0)));
	}
	@Test
	public void contextLoads1() {
		assertEquals(true, login(accountDTOs.get(1)));
	}

}
