package com.hoangnt.model;

public class UserDTO {
	Integer id;
	String full_name;

	String id_person;
	String date_of_birth;
	boolean sex;

	boolean is_vol;
	String carrer;
	boolean free;
	String free_detail;
	String phone;
	Integer role_id;
	Integer area_id;
	private AddressDTO addressDTO;
	private AccountDTO accountDTO;
	private SalaryDTO salaryDTO;

	public UserDTO() {
		super();
	}

	public UserDTO(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public boolean isIs_vol() {
		return is_vol;
	}

	public void setIs_vol(boolean is_vol) {
		this.is_vol = is_vol;
	}

	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public String getFree_detail() {
		return free_detail;
	}

	public void setFree_detail(String free_detail) {
		this.free_detail = free_detail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public SalaryDTO getSalaryDTO() {
		return salaryDTO;
	}

	public void setSalaryDTO(SalaryDTO salaryDTO) {
		this.salaryDTO = salaryDTO;
	}

	public String getId_person() {
		return id_person;
	}

	public void setId_person(String id_person) {
		this.id_person = id_person;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Integer getArea_id() {
		return area_id;
	}

	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}

}
