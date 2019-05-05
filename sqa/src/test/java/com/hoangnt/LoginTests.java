package com.hoangnt;

import static org.junit.Assert.assertEquals;

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

	// ham login username password cua user
	public boolean login(String username, String password) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUsername(username);
		accountDTO.setPassword(password);

		if (userService.login(accountDTO) != null) { // neu username password cua user la dung
			return true;
		}

		return false;
	}

	// truong hop login account dung
	@Test
	public void contextLoads() {
		assertEquals(true, login("trihoangdeptrai@gmail.com", "12345678"));
	}

	// truogn hop login account sai
	@Test
	public void contextLoads1() {
		assertEquals(false, login("xzxzxzzx@gmail.com", "220197"));

	}

}
