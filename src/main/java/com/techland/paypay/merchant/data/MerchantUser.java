package com.techland.paypay.merchant.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantUser {
	
	private String id;
	private String email;
	private String fullname;
	private String role;
	private String status;
	private  String merchantId;
	private  String userId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "{\"class\":\"MerchantUser\",\"id\":\"" + id + "\", \"email\":\"" + email + "\", \"fullname\":\""
				+ fullname + "\", \"role\":\"" + role + "\", \"status\":\"" + status + "\", \"merchantId\":\""
				+ merchantId + "\", \"userId\":\"" + userId + "\"}";
	}
	
	
	

}
