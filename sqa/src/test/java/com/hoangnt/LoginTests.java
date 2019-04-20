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
	
	public boolean login(String email,String password) {
		AccountDTO accountDTO=new AccountDTO();
		accountDTO.setUsername(email);
		accountDTO.setPassword(password);
		
		if(userService.login(accountDTO)!=null) {
			return true;
		}
		
		return false;
	}
	
	@Test
	public void contextLoads() {
		assertEquals(true, login("11111@gmail.com","140697"));
	}
}
