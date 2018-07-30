package com.ga.capitalmgmtplatform.pojo;

public class User {

	private Long id;
	private String name;
	private String passwd;
	private String salt;
	private String phone;
	private String depart;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return passwd;
	}

	public void setPassword(String passwd) {
		this.passwd = passwd == null ? null : passwd.trim();
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart == null ? null : depart.trim();
	}
}