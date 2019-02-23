package com.hoangnt.model;

public class AreaDTO {
	Integer id;
	String name;
	Double min_sal;
	Double max_sal;

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
