package com.hoangnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hoangnt.model.QuanHuyenDTO;
import com.hoangnt.service.QuanHuyenService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class QuanHuyenController {
	@Autowired
	QuanHuyenService quanHuyenService;

	@GetMapping("location/district/{id}")
	public ResponseEntity<?> getDistrictById(@PathVariable String id) {
		QuanHuyenDTO quanHuyenDTO = quanHuyenService.findById(id);
		if (quanHuyenDTO != null) {
			return new ResponseEntity<QuanHuyenDTO>(quanHuyenDTO, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
