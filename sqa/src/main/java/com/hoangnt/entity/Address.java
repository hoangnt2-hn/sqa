package com.hoangnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@OneToOne()
	@JoinColumn(name = "matp")
	private TinhThanhPho province;

	@OneToOne()
	@JoinColumn(name = "maqh")
	private QuanHuyen district;

	@OneToOne()
	@JoinColumn(name = "xaid")
	private XaPhuongThiTran town;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TinhThanhPho getProvince() {
		return province;
	}

	public void setProvince(TinhThanhPho province) {
		this.province = province;
	}

	public QuanHuyen getDistrict() {
		return district;
	}

	public void setDistrict(QuanHuyen district) {
		this.district = district;
	}

	public XaPhuongThiTran getTown() {
		return town;
	}

	public void setTown(XaPhuongThiTran town) {
		this.town = town;
	}

}
