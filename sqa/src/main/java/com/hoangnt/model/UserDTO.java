package com.hoangnt.model;

public class UserDTO {
	Integer id;
	String full_name;

	String id_person;
	String date_of_birth;
	boolean is_male;

	boolean is_vol;
	String career;
	boolean is_free;
	String free_detail;
	String phone;
	Integer role_id;
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

	public String getCareer() {
		return career;
	}

	public void setCareer(String carrer) {
		this.career = carrer;
	}

	public boolean isIs_free() {
		return is_free;
	}

	public void setIs_free(boolean free) {
		this.is_free = free;
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

	public boolean isIs_male() {
		return is_male;
	}

	public void setIs_male(boolean sex) {
		this.is_male = sex;
	}

}
