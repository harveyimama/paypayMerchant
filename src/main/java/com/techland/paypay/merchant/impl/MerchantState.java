package com.techland.paypay.merchant.impl;

import java.sql.Timestamp;

import com.techland.paypay.contracts.PayPayState;
import com.techland.paypay.contracts.TechLandState;
@TechLandState
public class MerchantState implements PayPayState {
	
	private  String id ;
	private  String eventId;
	private  Timestamp timestamp;
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
	public String getEventId() {
		return eventId;
	}
	public Timestamp getTimestamp() {
		return timestamp;
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
	@Override
	public PayPayState getState(String userState) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addEvent(String userEvent) {
		// TODO Auto-generated method stub
		
	}
	
	

}
