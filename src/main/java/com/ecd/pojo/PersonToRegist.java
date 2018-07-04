package com.ecd.pojo;

public class PersonToRegist {

	private String regist_person_email;
	private String regist_person_name;
	private String regist_person_gender;
	private String regist_person_verify;
	private String regist_person_phone;
	private String regist_person_password;

	public String getRegist_person_email() {
		return regist_person_email;
	}

	public void setRegist_person_email(String regist_person_email) {
		this.regist_person_email = regist_person_email;
	}

	public String getRegist_person_name() {
		return regist_person_name;
	}

	public void setRegist_person_name(String regist_person_name) {
		this.regist_person_name = regist_person_name;
	}

	public String getRegist_person_gender() {
		return regist_person_gender;
	}

	public void setRegist_person_gender(String regist_person_gender) {
		this.regist_person_gender = regist_person_gender;
	}

	public String getRegist_person_verify() {
		return regist_person_verify;
	}

	public void setRegist_person_verify(String regist_person_verify) {
		this.regist_person_verify = regist_person_verify;
	}

	public String getRegist_person_phone() {
		return regist_person_phone;
	}

	public void setRegist_person_phone(String regist_person_phone) {
		this.regist_person_phone = regist_person_phone;
	}

	public String getRegist_person_password() {
		return regist_person_password;
	}

	public void setRegist_person_password(String regist_person_password) {
		this.regist_person_password = regist_person_password;
	}

	@Override
	public String toString() {
		return "PersonToRegist [regist_person_email=" + regist_person_email + ", regist_person_name="
				+ regist_person_name + ", regist_person_gender=" + regist_person_gender + ", regist_person_verify="
				+ regist_person_verify + ", regist_person_phone=" + regist_person_phone + ", regist_person_password="
				+ regist_person_password + "]";
	}

	public PersonToRegist(String regist_person_email, String regist_person_name, String regist_person_gender,
			String regist_person_verify, String regist_person_phone, String regist_person_password) {
		super();
		this.regist_person_email = regist_person_email;
		this.regist_person_name = regist_person_name;
		this.regist_person_gender = regist_person_gender;
		this.regist_person_verify = regist_person_verify;
		this.regist_person_phone = regist_person_phone;
		this.regist_person_password = regist_person_password;
	}

	public PersonToRegist() {
		// TODO Auto-generated constructor stub
	}

}
