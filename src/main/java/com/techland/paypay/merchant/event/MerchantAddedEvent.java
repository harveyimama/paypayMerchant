package com.techland.paypay.merchant.event;

import java.io.Serializable;
import java.sql.Timestamp;

import com.techland.paypay.contracts.PayPayEvent;
import com.techland.paypay.contracts.TechLandEvent;
import com.techland.paypay.merchant.helper.Settings;
@TechLandEvent(externalName = "Merchant.MerchantAddedEvent")
public class MerchantAddedEvent implements PayPayEvent,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String id ;
	private final String eventId;
	private final Timestamp timestamp;
	private final String name;
	private final String category;
	private final String email;
	private final String phone;
	private final String address;
	private final String RCCNumber;
	private final String businessDescription;
	
	
	
	public MerchantAddedEvent(String id, String eventId, Timestamp timestamp, String name, String category,
			String email, String phone, String address, String rCCNumber, String businessDescription) {

		this.id = id;
		this.eventId = eventId;
		this.timestamp = timestamp;
		this.name = name;
		this.category = category;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.RCCNumber = rCCNumber;
		this.businessDescription = businessDescription;
	}
	
	public MerchantAddedEvent(String id, String name, String category,
			String email, String phone, String address, String rCCNumber, String businessDescription) {
	
		this.id = id;
		this.eventId = com.techland.paypay.Settings.aggregateTag();
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.name = name;
		this.category = category;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.RCCNumber = rCCNumber;
		this.businessDescription = businessDescription;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getEventId() {
		return this.eventId;
	}

	@Override
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	@Override
	public String getObiquitusName() {
		return Settings.DOMAIN+"."+this.getClass().getSimpleName();
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
	
	

}
