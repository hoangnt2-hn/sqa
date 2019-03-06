package com.hoangnt.model;

public class XaPhuongThiTranDTO {
	String xaid;

	String name;
	String type;

	public XaPhuongThiTranDTO(String xaid) {
		super();
		this.xaid = xaid;
	}

	public XaPhuongThiTranDTO() {
		super();
	}

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

}
