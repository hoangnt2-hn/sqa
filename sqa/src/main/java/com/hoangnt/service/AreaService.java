package com.hoangnt.service;

import java.util.List;

import com.hoangnt.model.AreaDTO;

public interface AreaService {
	void addAreaDTO(AreaDTO areaDTO);

	AreaDTO getAreaById(int id);

	void updateAreaDTO(AreaDTO areaDTO);

	void deleteArea(int id);

	List<AreaDTO> getAllArea();
}
