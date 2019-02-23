package com.hoangnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coefficient")
public class Coefficient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Double coe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCoe() {
		return coe;
	}

	public void setCoe(Double coe) {
		this.coe = coe;
	}

}
