package com.techland.paypay.merchant.event;

import java.io.Serializable;
import java.sql.Timestamp;
import com.techland.paypay.contracts.PayPayEvent;
import com.techland.paypay.contracts.TechLandEvent;
import com.techland.paypay.merchant.helper.Settings;
@TechLandEvent(externalName = "Merchant.UserMerchantAddedEvent")
public class UserMerchantAddedEvent implements PayPayEvent, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String id;
	private final String userId;
	private final String email;
	private final String fullname;
	private final String role;
	private final String username;
	private final String password; //TODO encrypt
	private final String eventId;
	private final Timestamp timestamp;

	public UserMerchantAddedEvent(String id,String userId, String email, String fullname, String role,String username,String password, String eventId,
			Timestamp timestamp) {
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.role = role;
		this.eventId = eventId;
		this.timestamp = timestamp;
		this.username = username;
		this.password = password;
		this.userId = userId;
	}

	public UserMerchantAddedEvent(String id, String userId,String email, String fullname, String role,String username,String password) {
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.role = role;
		this.eventId = com.techland.paypay.Settings.aggregateTag();
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.username = username;
		this.password = password;
		this.userId = userId;
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
		return Settings.DOMAIN + "." + this.getClass().getSimpleName();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public String getFullname() {
		return fullname;
	}

	public String getRole() {
		return role;
	}
	

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "{\"class\":\"UserMerchantAddedEvent\",\"id\":\"" + id + "\", \"userId\":\"" + userId
				+ "\", \"email\":\"" + email + "\", \"fullname\":\"" + fullname + "\", \"role\":\"" + role
				+ "\", \"username\":\"" + username + "\", \"password\":\"" + password + "\", \"eventId\":\"" + eventId
				+ "\", \"timestamp\":\"" + timestamp + "\"}";
	}

	

	

}
