package com.hoangnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	Double min_sal;
	Double max_sal;

	public Area() {
		super();
	}

	public Area(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMin_sal() {
		return min_sal;
	}

	public void setMin_sal(Double min_sal) {
		this.min_sal = min_sal;
	}

	public Double getMax_sal() {
		return max_sal;
	}

	public void setMax_sal(Double max_sal) {
		this.max_sal = max_sal;
	}
}
