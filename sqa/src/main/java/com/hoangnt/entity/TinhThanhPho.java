package com.hoangnt.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "devvn_tinhthanhpho")
public class TinhThanhPho {
	@Id
	String matp;
	String name;
	String type;

	@OneToMany(mappedBy = "tinhThanhPho", fetch = FetchType.LAZY)
	List<QuanHuyen> quanHuyens;

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

	public List<QuanHuyen> getQuanHuyens() {
		return quanHuyens;
	}

	public void setQuanHuyens(List<QuanHuyen> quanHuyens) {
		this.quanHuyens = quanHuyens;
	}

}
