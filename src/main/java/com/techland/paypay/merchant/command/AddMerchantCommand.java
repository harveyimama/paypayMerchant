package com.techland.paypay.merchant.command;

public class AddMerchantCommand {
	
	private  String id ;
	private  String name;
	private  String category;
	private  String email;
	private  String phone;
	private  String address;
	private  String RCCNumber;
	private  String businessDescription;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRCCNumber() {
		return RCCNumber;
	}
	public void setRCCNumber(String rCCNumber) {
		RCCNumber = rCCNumber;
	}
	public String getBusinessDescription() {
		return businessDescription;
	}
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	
	

}
