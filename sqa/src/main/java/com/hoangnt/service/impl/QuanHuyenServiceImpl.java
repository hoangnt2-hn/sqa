package com.hoangnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangnt.entity.QuanHuyen;
import com.hoangnt.model.QuanHuyenDTO;
import com.hoangnt.model.XaPhuongThiTranDTO;
import com.hoangnt.repository.QuanHuyenRepository;
import com.hoangnt.service.QuanHuyenService;

@Service
@Transactional
public class QuanHuyenServiceImpl implements QuanHuyenService {

	@Autowired
	QuanHuyenRepository quanHuyenRepository;

	@Override
	public QuanHuyenDTO findById(String id) {
		QuanHuyenDTO quanHuyenDTO = new QuanHuyenDTO();
		QuanHuyen quanHuyen = quanHuyenRepository.getOne(id);
		quanHuyenDTO.setMaqh(quanHuyen.getMaqh());
		quanHuyenDTO.setName(quanHuyen.getName());
		quanHuyenDTO.setType(quanHuyen.getType());
		List<XaPhuongThiTranDTO> xaPhuongThiTranDTOs = new ArrayList<>();

		quanHuyen.getXaPhuongThiTrans().forEach(xa -> {
			XaPhuongThiTranDTO xaPhuongThiTranDTO = new XaPhuongThiTranDTO();
			xaPhuongThiTranDTO.setXaid(xa.getXaid());
			xaPhuongThiTranDTO.setName(xa.getName());
			xaPhuongThiTranDTO.setType(xa.getType());

			xaPhuongThiTranDTOs.add(xaPhuongThiTranDTO);
		});
		quanHuyenDTO.setXaPhuongThiTranDTOs(xaPhuongThiTranDTOs);

		return quanHuyenDTO;
	}

}
