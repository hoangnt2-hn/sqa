package com.hoangnt.service;

import java.util.List;

import com.hoangnt.model.CoefficientDTO;

public interface CoefficientService {
	void addCoefficientDTO(CoefficientDTO coefficientDTO);

	CoefficientDTO getCoefficientById(int id);

	void updateCoefficientDTO(CoefficientDTO coefficientDTO);

	void deleteCoefficient(int id);

	List<CoefficientDTO> getAllCoefficient();
}
