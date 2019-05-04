package com.hoangnt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoangnt.entity.Address;
import com.hoangnt.entity.Area;
import com.hoangnt.entity.QuanHuyen;
import com.hoangnt.entity.Salary;
import com.hoangnt.entity.User;
import com.hoangnt.model.AreaDTO;
import com.hoangnt.model.CoefficientDTO;
import com.hoangnt.service.AreaService;
import com.hoangnt.service.CoefficientService;
import com.hoangnt.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsuranceTests {
	@Autowired
	AreaService areaService;

	@Autowired
	CoefficientService coefficientService;

	public Double middleware(Double main_sal, Double position_allowrance, Double res_allowrance, int area,
			boolean is_vol, boolean is_free) {
		User user = new User();
		Salary salary = new Salary();
		Address address = new Address();
		QuanHuyen quanHuyen = new QuanHuyen();

		salary.setMain_sal(main_sal);
		salary.setPosition_allowrance(position_allowrance);
		salary.setRes_allowrance(res_allowrance);

		AreaDTO areaDTO = areaService.getAreaById(area);
		Area area2 = new Area();
		area2.setMax_sal(areaDTO.getMax_sal());
		area2.setMin_sal(areaDTO.getMin_sal());

		quanHuyen.setArea(area2);
		address.setDistrict(quanHuyen);

		user.setSalary(salary);
		user.setAddress(address);
		user.setIs_free(is_free);
		user.setIs_vol(is_vol);

		CoefficientDTO coefficientDTO = coefficientService.getCoefficientById(1);

		return UserServiceImpl.insurance(coefficientDTO.getCoe(), user);

	}
	
	@Test
	public void contextLoads() {
		assertEquals(new Double(0.0), middleware(59000001.0, 300000.0, 700000.0, 1, false, true));
	}

	@Test
	public void contextLoads1() {
		assertEquals(new Double(334400.0), middleware(1000000.0, 300000.0, 700000.0, 1, true, true));
	}

	@Test
	public void contextLoads2() {
		assertEquals(new Double(2224000.0), middleware(59000000.0, 300000.0, 700000.0, 1, true, true));
	}
	@Test
	public void contextLoads3() {
		assertEquals(new Double(0.0), middleware(1000000.0, 300000.0, 700000.0, 1, false, true));
	}
	@Test
	public void contextLoads4() {
		assertEquals(new Double(520000.0), middleware(5000000.0, 1000000.0, 500000.0, 1, true, true));
	}
	

}
