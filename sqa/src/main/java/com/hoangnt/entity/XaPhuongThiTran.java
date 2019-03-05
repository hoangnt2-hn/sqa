package com.hoangnt.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "devvn_xaphuongthitran")
public class XaPhuongThiTran {
	@Id
	String xaid;

	String name;
	String type;
	String maqh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matp")
	QuanHuyen quanHuyen;

	public String getXaid() {
		return xaid;
	}

	public void setXaid(String xaid) {
		this.xaid = xaid;
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

	public String getMaqh() {
		return maqh;
	}

	public void setMaqh(String maqh) {
		this.maqh = maqh;
	}

	public QuanHuyen getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(QuanHuyen quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

}
