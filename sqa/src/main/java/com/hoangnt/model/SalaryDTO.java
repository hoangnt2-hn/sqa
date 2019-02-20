package com.hoangnt.model;

public class SalaryDTO {
	Integer id;
	Double main_sal;
	Double position_allowrance;
	Double res_allowrance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMain_sal() {
		return main_sal;
	}

	public void setMain_sal(Double main_sal) {
		this.main_sal = main_sal;
	}

	public Double getPosition_allowrance() {
		return position_allowrance;
	}

	public void setPosition_allowrance(Double position_allowrance) {
		this.position_allowrance = position_allowrance;
	}

	public Double getRes_allowrance() {
		return res_allowrance;
	}

	public void setRes_allowrance(Double res_allowrance) {
		this.res_allowrance = res_allowrance;
	}

}
