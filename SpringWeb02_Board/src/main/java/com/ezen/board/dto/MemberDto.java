package com.ezen.board.dto;

public class MemberDto {
	private String userid;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String id) {
		this.userid = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
