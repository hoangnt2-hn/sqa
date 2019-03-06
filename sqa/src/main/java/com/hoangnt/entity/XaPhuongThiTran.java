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

	public XaPhuongThiTran() {
		super();
	}

	public XaPhuongThiTran(String xaid) {
		super();
		this.xaid = xaid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maqh")
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

	public QuanHuyen getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(QuanHuyen quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

}
