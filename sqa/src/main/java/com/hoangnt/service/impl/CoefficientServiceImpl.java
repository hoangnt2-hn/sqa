package com.hoangnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangnt.entity.Coefficient;
import com.hoangnt.model.CoefficientDTO;
import com.hoangnt.repository.CoefficientRepository;
import com.hoangnt.service.CoefficientService;

@Transactional
@Service
public class CoefficientServiceImpl implements CoefficientService {
	@Autowired
	CoefficientRepository coefficientRepository;

	@Override
	public void addCoefficientDTO(CoefficientDTO coefficientDTO) {
		Coefficient coefficient = new Coefficient();
		coefficient.setCoe(coefficientDTO.getCoe());
//		coefficient.setId(coefficientDTO.getId());
		coefficientRepository.save(coefficient);
	}

	@Override
	public CoefficientDTO getCoefficientById(int id) {
		Coefficient coefficient = coefficientRepository.getOne(id);
		CoefficientDTO coefficientDTO = new CoefficientDTO();
		coefficientDTO.setId(coefficient.getId());
		coefficientDTO.setCoe(coefficient.getCoe());
		return coefficientDTO;
	}

	@Override
	public void updateCoefficientDTO(CoefficientDTO coefficientDTO) {
		Coefficient coefficient = coefficientRepository.getOne(coefficientDTO.getId());
		coefficient.setCoe(coefficientDTO.getCoe());
//		coefficient.setId(coefficientDTO.getId());
		coefficientRepository.save(coefficient);
	}

	@Override
	public void deleteCoefficient(int id) {
		coefficientRepository.deleteById(id);

	}

	@Override
	public List<CoefficientDTO> getAllCoefficient() {
		List<CoefficientDTO> coefficientDTOs = new ArrayList<CoefficientDTO>();
		coefficientRepository.findAll().forEach(coefficient -> {
			CoefficientDTO coefficientDTO = new CoefficientDTO();
			coefficientDTO.setId(coefficient.getId());
			coefficientDTO.setCoe(coefficient.getCoe());
			coefficientDTOs.add(coefficientDTO);
		});
		return coefficientDTOs;
	}

}
