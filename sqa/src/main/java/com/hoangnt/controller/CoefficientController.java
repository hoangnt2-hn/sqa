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

import com.hoangnt.model.CoefficientDTO;
import com.hoangnt.service.CoefficientService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class CoefficientController {
	@Autowired
	CoefficientService coefficientService;

	@GetMapping("/coefficients")
	public ResponseEntity<List<CoefficientDTO>> getAllCoefficient() {
		return new ResponseEntity<List<CoefficientDTO>>(coefficientService.getAllCoefficient(), HttpStatus.OK);
	}

	@GetMapping("/coefficients/{id}")
	public ResponseEntity<CoefficientDTO> getCoefficientById(@PathVariable int id) {
		return new ResponseEntity<CoefficientDTO>(coefficientService.getCoefficientById(id), HttpStatus.OK);
	}

	@PostMapping("/coefficients/add")
	public ResponseEntity<Void> addCoefficient(@RequestBody CoefficientDTO coefficientDTO) {
		coefficientService.addCoefficientDTO(coefficientDTO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/coefficients/update")
	public ResponseEntity<Void> updateCoefficient(@RequestBody CoefficientDTO coefficientDTO) {
		coefficientService.updateCoefficientDTO(coefficientDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/coefficients/delete/{id}")
	public ResponseEntity<Void> deleteCoefficient(@PathVariable int id) {
		coefficientService.deleteCoefficient(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
