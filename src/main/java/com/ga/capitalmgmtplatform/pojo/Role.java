package com.ga.capitalmgmtplatform.pojo;

public class Role {
	private Long id;
	private String name;
	private String descp;

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

	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp == null ? null : descp.trim();
	}
}