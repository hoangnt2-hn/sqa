package com.hoangnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hoangnt.model.XaPhuongThiTranDTO;
import com.hoangnt.service.XaPhuongThiTranService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class XaPhuongThiTranController {
	@Autowired
	XaPhuongThiTranService xaPhuongThiTranService;

	@GetMapping("location/town/{id}")
	public ResponseEntity<?> getTownById(@PathVariable String id) {
		XaPhuongThiTranDTO xaPhuongThiTranDTO = xaPhuongThiTranService.findById(id);
		if (xaPhuongThiTranDTO != null) {
			return new ResponseEntity<XaPhuongThiTranDTO>(xaPhuongThiTranDTO, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
