package com.techland.paypay.merchant.impl;

import com.techland.paypay.merchant.helper.Settings;
import com.techland.paypay.PayPayPayLoad;
import com.techland.paypay.merchant.commands.AddMerchantCommand;
import com.techland.paypay.merchant.events.MerchandAddedEvent;
import com.techland.paypay.messaging.PayPayMessenger;
import com.techland.paypay.util.LogFeed;

public class MerhantEntity {
	
	private PayPayMessenger paypayMessenger;
	private LogFeed logfeed;

	public MerhantEntity(PayPayMessenger paypayMessenger, LogFeed logfeed) {

		this.paypayMessenger = paypayMessenger;
		this.logfeed = logfeed;

	}

	public void handleCommand(AddMerchantCommand cmd) {
		MerchandAddedEvent event = new MerchandAddedEvent();
		handleEvent(event);
	}

	public void handleEvent(MerchandAddedEvent event) {
		PayPayPayLoad load = new PayPayPayLoad.PayLoadBuilder()
				.setDomain(Settings.DOMAIN)
				.setEvent(event.toString())
				.setEventName(event.getObiquitusName())
				.build();
		paypayMessenger.sendMessage(load);
		
	}
}
