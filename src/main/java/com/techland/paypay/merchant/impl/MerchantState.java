package com.techland.paypay.merchant.impl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techland.paypay.contracts.PayPayState;
import com.techland.paypay.contracts.TechLandState;
import com.techland.paypay.merchant.command.UserCommand;
import com.techland.paypay.merchant.data.MerchantUser;

@TechLandState
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantState implements PayPayState {
	
	private  String id ;
	private  String name;
	private  String category;
	private  String email;
	private  String phone;
	private  String address;
	private  String RCCNumber;
	private  String businessDescription;
	private  List<MerchantUser> users;
	
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getRCCNumber() {
		return RCCNumber;
	}
	public String getBusinessDescription() {
		return businessDescription;
	}
	
	
	public List<MerchantUser> getUsers() {
		return users;
	}
	public void setUsers(List<MerchantUser> users) {
		this.users = users;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setRCCNumber(String rCCNumber) {
		RCCNumber = rCCNumber;
	}
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	
	@Override
	public PayPayState getState(String merchantState) {
		try {
			ObjectMapper mapper = new ObjectMapper();
				
			MerchantState actualObj = mapper.readValue(merchantState, MerchantState.class);
			this.address = actualObj.getAddress();
			this.businessDescription = actualObj.getBusinessDescription();
			this.category = actualObj.getCategory();
			this.email = actualObj.getEmail();
			this.id = actualObj.getId();
			this.name = actualObj.getName();
			this.phone = actualObj.getPhone();
			this.RCCNumber = actualObj.getRCCNumber();
			this.users = 	actualObj.getUsers();
		
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		return this;
	}
	
	@Override
	public MerchantState addEvent(String merchantEvent) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode json = mapper.readTree(merchantEvent);

			if (json.get("class").asText().equals("MerchantAddedEvent")) {
			MerchantState actualObj = mapper.readValue(merchantEvent, MerchantState.class);
			this.address = actualObj.getAddress();
			this.businessDescription = actualObj.getBusinessDescription();
			this.category = actualObj.getCategory();
			this.email = actualObj.getEmail();
			this.id = actualObj.getId();
			this.name = actualObj.getName();
			this.phone = actualObj.getPhone();
			this.RCCNumber = actualObj.getRCCNumber();		
			}
			else if (json.get("class").asText().equals("UserMerchantAddedEvent"))
			{
				MerchantUser actualObj = mapper.readValue(merchantEvent, MerchantUser.class);
				if(this.users == null)
					this.users = new ArrayList<MerchantUser>();
				
				this.users.add(actualObj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return this;
	}
	
	@Override
	public String toString() {
		return "{\"class\":\"MerchantState\",\"id\":\"" + id + "\", \"name\":\"" + name + "\", \"category\":\""
				+ category + "\", \"email\":\"" + email + "\", \"phone\":\"" + phone + "\", \"address\":\"" + address
				+ "\", \"RCCNumber\":\"" + RCCNumber + "\", \"businessDescription\":\"" + businessDescription
				+ "\", \"users\":\"" + users + "\"}";
	}
	
	

}
