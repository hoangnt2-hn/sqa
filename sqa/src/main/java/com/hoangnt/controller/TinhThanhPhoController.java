package com.hoangnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hoangnt.model.TinhThanhPhoDTO;
import com.hoangnt.service.TinhThanhPhoService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class TinhThanhPhoController {
	@Autowired
	TinhThanhPhoService tinhThanhPhoService;

	@GetMapping("location/province") //api tra ve list thanh pho
	public ResponseEntity<List<TinhThanhPhoDTO>> getAll() {
		return new ResponseEntity<List<TinhThanhPhoDTO>>(tinhThanhPhoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("location/province/{id}") // api tra ve thanh pho theo id thanh pho
	public ResponseEntity<?> getProvinceById(@PathVariable String id) {
		TinhThanhPhoDTO tinhThanhPhoDTO = tinhThanhPhoService.findById(id);
		if (tinhThanhPhoDTO != null) {
			return new ResponseEntity<TinhThanhPhoDTO>(tinhThanhPhoDTO, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
