package com.hoangnt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoangnt.entity.Address;
import com.hoangnt.entity.Area;
import com.hoangnt.entity.QuanHuyen;
import com.hoangnt.entity.Salary;
import com.hoangnt.entity.User;
import com.hoangnt.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SqaApplicationTests {
	public Double compare() {
		Salary salary=new Salary();
		salary.setMain_sal(59000001.0);
		salary.setPosition_allowrance(300000.0);
		salary.setRes_allowrance(700000.0);
		
		Address address=new Address();
		
		QuanHuyen quanHuyen=new QuanHuyen();
		
		Area area=new Area();
		area.setMax_sal(29800000.0);
		area.setMin_sal(4180000.0);
		quanHuyen.setArea(area);
		
		address.setDistrict(quanHuyen);
		
		User user=new User();
		user.setSalary(salary);
		user.setAddress(address);
		
		return UserServiceImpl.insurance(0.08, user);
	}
	@Test
	public void contextLoads() {
		assertEquals(new Double(2384000.0), compare());	
	}

}
