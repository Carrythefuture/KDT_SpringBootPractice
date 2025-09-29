package com.kedu.study.DTO;

public class AuthDTO {
	private String id;
	private String pw;
	private String name;
	
	public AuthDTO() {
		super();
	}
	public AuthDTO(String id, String pw , String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
