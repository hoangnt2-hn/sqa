package com.hoangnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangnt.entity.Area;
import com.hoangnt.model.AreaDTO;
import com.hoangnt.repository.AreaRepository;
import com.hoangnt.service.AreaService;

@Transactional
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaRepository areaRepository;

	@Override
	public void addAreaDTO(AreaDTO areaDTO) {
		Area area = new Area();
		area.setName(areaDTO.getName());
		area.setMin_sal(areaDTO.getMin_sal());
		area.setMax_sal(areaDTO.getMax_sal());

		areaRepository.save(area);
	}

	@Override
	public AreaDTO getAreaById(int id) {
		Area area = areaRepository.getOne(id);

		AreaDTO areaDTO = new AreaDTO();
		if (area.getId() > 0) {
			areaDTO.setId(area.getId());
			areaDTO.setName(area.getName());
			areaDTO.setMin_sal(area.getMin_sal());
			areaDTO.setMax_sal(area.getMax_sal());
		}
		return areaDTO;
	}

	@Override
	public void updateAreaDTO(AreaDTO areaDTO) {
		Area area = areaRepository.getOne(areaDTO.getId());
		area.setName(areaDTO.getName());
		area.setMin_sal(areaDTO.getMin_sal());
		area.setMax_sal(areaDTO.getMax_sal());

		areaRepository.save(area);

	}

	@Override
	public void deleteArea(int id) {
		areaRepository.deleteById(id);

	}

	@Override
	public List<AreaDTO> getAllArea() {
		List<AreaDTO> areaDTOs = new ArrayList<AreaDTO>();
		areaRepository.findAll().forEach(area -> {
			AreaDTO areaDTO = new AreaDTO();

			areaDTO.setId(area.getId());
			areaDTO.setName(area.getName());
			areaDTO.setMin_sal(area.getMin_sal());
			areaDTO.setMax_sal(area.getMax_sal());

			areaDTOs.add(areaDTO);

		});
		return areaDTOs;
	}

}
