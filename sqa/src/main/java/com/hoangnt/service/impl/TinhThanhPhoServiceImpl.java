package com.hoangnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangnt.entity.TinhThanhPho;
import com.hoangnt.model.QuanHuyenDTO;
import com.hoangnt.model.TinhThanhPhoDTO;
import com.hoangnt.repository.TinhThanhPhoRepository;
import com.hoangnt.service.TinhThanhPhoService;

@Service
@Transactional
public class TinhThanhPhoServiceImpl implements TinhThanhPhoService {

	@Autowired
	TinhThanhPhoRepository tinhThanhPhoRepository;

	@Override
	public TinhThanhPhoDTO findById(String id) { // lay thanh pho theo id kem theo danh sach huyen
		TinhThanhPho tinhThanhPho = tinhThanhPhoRepository.getOne(id);
		TinhThanhPhoDTO tinhThanhPhoDTO = new TinhThanhPhoDTO();
		tinhThanhPhoDTO.setMatp(tinhThanhPho.getMatp());
		tinhThanhPhoDTO.setName(tinhThanhPho.getName());
		tinhThanhPhoDTO.setType(tinhThanhPho.getType());

		List<QuanHuyenDTO> quanHuyenDTOs = new ArrayList<>();
		tinhThanhPho.getQuanHuyens().forEach(quanHuyen -> {
			QuanHuyenDTO quanHuyenDTO = new QuanHuyenDTO();
			quanHuyenDTO.setMaqh(quanHuyen.getMaqh());
			quanHuyenDTO.setName(quanHuyen.getName());
			quanHuyenDTO.setType(quanHuyen.getType());

			quanHuyenDTOs.add(quanHuyenDTO);

		});
		tinhThanhPhoDTO.setQuanHuyenDTOs(quanHuyenDTOs);
		return tinhThanhPhoDTO;
	}

	@Override
	public List<TinhThanhPhoDTO> findAll() { // lay tat ca cac thanh pho
		List<TinhThanhPhoDTO> tinhThanhPhoDTOs=new ArrayList<>();
		tinhThanhPhoRepository.findAll().forEach(tinhThanhPho->{
			
			TinhThanhPhoDTO tinhThanhPhoDTO = new TinhThanhPhoDTO();
			tinhThanhPhoDTO.setMatp(tinhThanhPho.getMatp());
			tinhThanhPhoDTO.setName(tinhThanhPho.getName());
			tinhThanhPhoDTO.setType(tinhThanhPho.getType());

			tinhThanhPhoDTOs.add(tinhThanhPhoDTO);
		});
		
		return tinhThanhPhoDTOs;
	}

}
