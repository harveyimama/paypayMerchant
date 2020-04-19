package com.techland.paypay.merchant.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommand {
	private String id;
	private String email;
	private String fullname;
	private String username;
	private String password;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "{\"class\":\"UserCommand\",\"id\":\"" + id + "\", \"email\":\"" + email + "\", \"fullname\":\""
				+ fullname + "\", \"username\":\"" + username + "\", \"password\":\"" + password + "\", \"role\":\""
				+ role + "\"}";
	}
	
	
	
	
	
}
