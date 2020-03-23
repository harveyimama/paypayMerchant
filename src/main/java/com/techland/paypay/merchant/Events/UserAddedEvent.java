package com.techland.paypay.merchant.events;

import java.sql.Timestamp;

import com.techland.paypay.contracts.PayPayEvent;
import com.techland.paypay.contracts.TechLandEvent;
@TechLandEvent(externalName = "Merchant.UserAddedEvent")
public class UserAddedEvent implements PayPayEvent {

	@Override
	public String getEventId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObiquitusName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp() {
		// TODO Auto-generated method stub
		return null;
	}

}
