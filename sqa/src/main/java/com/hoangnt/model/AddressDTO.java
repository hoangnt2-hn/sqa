package com.hoangnt.model;

public class AddressDTO {
	Integer id;
	TinhThanhPhoDTO province;
	QuanHuyenDTO district;
	XaPhuongThiTranDTO town;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TinhThanhPhoDTO getProvince() {
		return province;
	}

	public void setProvince(TinhThanhPhoDTO tinhThanhPhoDTO) {
		this.province = tinhThanhPhoDTO;
	}

	public QuanHuyenDTO getDistrict() {
		return district;
	}

	public void setDistrict(QuanHuyenDTO quanHuyenDTO) {
		this.district = quanHuyenDTO;
	}

	public XaPhuongThiTranDTO getTown() {
		return town;
	}

	public void setTown(XaPhuongThiTranDTO xaPhuongThiTranDTO) {
		this.town = xaPhuongThiTranDTO;
	}

}
