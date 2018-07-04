package com.ecd.pojo;

/**
 * 本系统的参与人员 分为执法人员、环保人员、后台管理人员
 * 
 * @author Administrator
 *
 */
public class Person {

	private String email;// 作为唯一识别的email
	private String password;// 存储使用者的登录密码
	private String name;// 使用者的名字
	private String gender;// 使用者的性别
	private String identity;// 使用者的身份识别
	private String phone;// 使用的手机号码：留做后期的短信通知功能开发
	private int state;// 登录状态模块：为后期的单点登录做准备

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Person(String email, String password, String name, String gender, String identity, String phone, int state) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.identity = identity;
		this.phone = phone;
		this.state = state;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [email=" + email + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", identity=" + identity + ", phone=" + phone + ", state=" + state + "]";
	}

}
