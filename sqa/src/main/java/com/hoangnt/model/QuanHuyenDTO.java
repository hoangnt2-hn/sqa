package com.hoangnt.model;

import java.util.List;

public class QuanHuyenDTO {
	String maqh;
	String name;
	String type;
	List<XaPhuongThiTranDTO> xaPhuongThiTranDTOs;
	AreaDTO areaDTO;

	public QuanHuyenDTO(String maqh) {
		super();
		this.maqh = maqh;
	}

	public QuanHuyenDTO() {
		super();
	}

	public String getMaqh() {
		return maqh;
	}

	public void setMaqh(String maqh) {
		this.maqh = maqh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<XaPhuongThiTranDTO> getXaPhuongThiTranDTOs() {
		return xaPhuongThiTranDTOs;
	}

	public void setXaPhuongThiTranDTOs(List<XaPhuongThiTranDTO> xaPhuongThiTranDTOs) {
		this.xaPhuongThiTranDTOs = xaPhuongThiTranDTOs;
	}

	public AreaDTO getAreaDTO() {
		return areaDTO;
	}

	public void setAreaDTO(AreaDTO areaDTO) {
		this.areaDTO = areaDTO;
	}

}
