package com.hoangnt.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "devvn_quanhuyen")
public class QuanHuyen {
	@Id
	String maqh;
	String name;
	String type;

	public QuanHuyen() {
		super();
	}

	public QuanHuyen(String maqh) {
		this.maqh = maqh;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matp")
	TinhThanhPho tinhThanhPho;

	@OneToMany(mappedBy = "quanHuyen", fetch = FetchType.LAZY)
	List<XaPhuongThiTran> xaPhuongThiTrans;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area")
	Area area;

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

	public TinhThanhPho getTinhThanhPho() {
		return tinhThanhPho;
	}

	public void setTinhThanhPho(TinhThanhPho tinhThanhPho) {
		this.tinhThanhPho = tinhThanhPho;
	}

	public List<XaPhuongThiTran> getXaPhuongThiTrans() {
		return xaPhuongThiTrans;
	}

	public void setXaPhuongThiTrans(List<XaPhuongThiTran> xaPhuongThiTrans) {
		this.xaPhuongThiTrans = xaPhuongThiTrans;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
