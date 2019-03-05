package com.hoangnt.model;

import java.util.List;

public class QuanHuyenDTO {
	String maqh;
	String name;
	String type;
	List<XaPhuongThiTranDTO> xaPhuongThiTranDTOs;

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

}
