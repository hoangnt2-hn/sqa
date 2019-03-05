package com.hoangnt.model;

import java.util.List;

public class TinhThanhPhoDTO {
	String matp;
	String name;
	String type;
	List<QuanHuyenDTO> quanHuyenDTOs;

	public String getMatp() {
		return matp;
	}

	public void setMatp(String matp) {
		this.matp = matp;
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

	public List<QuanHuyenDTO> getQuanHuyenDTOs() {
		return quanHuyenDTOs;
	}

	public void setQuanHuyenDTOs(List<QuanHuyenDTO> quanHuyenDTOs) {
		this.quanHuyenDTOs = quanHuyenDTOs;
	}

}
