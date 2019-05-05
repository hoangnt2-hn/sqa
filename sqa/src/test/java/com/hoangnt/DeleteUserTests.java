package com.hoangnt;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoangnt.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DeleteUserTests {
	@Autowired
	UserService userService;

	public boolean deleteUser(int id) {
		String email = userService.getUserById(id).getEmail();
		userService.deleteUser(11);
		if (userService.getUserByEmail(email) == null) { // neu user duoc xoa
			return true;
		}

		return false; // neu user chua duoc xoa
	}

	@Test
	public void contextLoads() {
		assertEquals(true, deleteUser(11));
	}
}
