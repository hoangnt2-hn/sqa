package com.hoangnt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoangnt.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetUserByEmailTests {
	@Autowired
	UserService userService;

	public boolean getUserByEmail(String email) {

		if (userService.getUserByEmail(email) != null) { // neu email cua user la dung
			return true;
		}

		return false;
	}

	// truong hop email dung
	@Test
	public void contextLoads() {
		assertEquals(true, getUserByEmail("trihoangdeptrai@gmail.com"));
	}

	// truogn hop email sai
	@Test
	public void contextLoads1() {
		assertEquals(false, getUserByEmail("zxzxzxzxzxzx@gmail.com"));

	}
}
