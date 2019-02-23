package com.hoangnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoangnt.model.AreaDTO;
import com.hoangnt.service.AreaService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class AreaController {

	@Autowired
	AreaService areaService;

	@GetMapping("/areas")
	public ResponseEntity<List<AreaDTO>> getAllArea() {
		return new ResponseEntity<List<AreaDTO>>(areaService.getAllArea(), HttpStatus.OK);
	}

	@GetMapping("/areas/{id}")
	public ResponseEntity<AreaDTO> getAreaById(@PathVariable int id) {
		return new ResponseEntity<AreaDTO>(areaService.getAreaById(id), HttpStatus.OK);
	}

	@PostMapping("/areas/add")
	public ResponseEntity<Void> addArea(@RequestBody AreaDTO areaDTO) {
		areaService.addAreaDTO(areaDTO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/areas/update")
	public ResponseEntity<Void> updateArea(@RequestBody AreaDTO areaDTO) {
		areaService.updateAreaDTO(areaDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/areas/delete/{id}")
	public ResponseEntity<Void> deleteArea(@PathVariable int id) {
		areaService.deleteArea(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
