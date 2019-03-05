package com.hoangnt.service;

import java.util.List;

import com.hoangnt.model.TinhThanhPhoDTO;

public interface TinhThanhPhoService {
	public TinhThanhPhoDTO findById(String id);
	
	public List<TinhThanhPhoDTO> findAll();
}
