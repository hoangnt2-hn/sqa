package com.hoangnt.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangnt.entity.XaPhuongThiTran;
import com.hoangnt.model.XaPhuongThiTranDTO;
import com.hoangnt.repository.XaPhuongThiTranRepository;
import com.hoangnt.service.XaPhuongThiTranService;

@Service
@Transactional
public class XaPhuongThiTranServiceImpl implements XaPhuongThiTranService {

	@Autowired
	XaPhuongThiTranRepository xaPhuongThiTranRepository;

	@Override
	public XaPhuongThiTranDTO findById(String id) {
		XaPhuongThiTranDTO xaPhuongThiTranDTO = new XaPhuongThiTranDTO();
		XaPhuongThiTran xaPhuongThiTran = xaPhuongThiTranRepository.getOne(id);

		xaPhuongThiTranDTO.setXaid(xaPhuongThiTran.getXaid());
		xaPhuongThiTranDTO.setName(xaPhuongThiTran.getName());
		xaPhuongThiTranDTO.setType(xaPhuongThiTran.getType());
		return xaPhuongThiTranDTO;
	}

}
