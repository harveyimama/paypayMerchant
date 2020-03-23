package com.techland.paypay.merchant.Events;

import java.sql.Timestamp;

import com.techland.paypay.contracts.PayPayEvent;
import com.techland.paypay.contracts.TechLandEvent;
@TechLandEvent(externalName = "Merchant.MerchandAddedEvent")
public class MerchandAddedEvent implements PayPayEvent {

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
