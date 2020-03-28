package com.techland.paypay.merchant.impl;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techland.paypay.PayPayPayLoad;
import com.techland.paypay.merchant.helper.Settings;
import com.techland.paypay.config.PayPayThread;
import com.techland.paypay.merchant.command.AddMerchantCommand;
import com.techland.paypay.merchant.event.MerchantAddedEvent;
import com.techland.paypay.merchant.helper.Constants;
import com.techland.paypay.messaging.PayPayMessenger;
import com.techland.paypay.util.LogFeed;
;

@Component
public final class MerchantEntity {
	@Autowired
	PayPayMessenger messenger;
	@Autowired
	LogFeed logfeed;

	public void handleCommand(AddMerchantCommand merchant) {
		MerchantAddedEvent event  = new MerchantAddedEvent(merchant.getId(),merchant.getName(),merchant.getCategory(),merchant.getEmail()
				,merchant.getPhone(),merchant.getAddress(),merchant.getRCCNumber(),merchant.getBusinessDescription());
		
		handleEvent(event);
		logfeed.getInstance(Constants.SUCESS_MESSAGE, MerchantEntity.class,Settings.DOMAIN, merchant.toString()).process();
		
	}
	
	
	public void handleEvent(MerchantAddedEvent event) {
		
		PayPayPayLoad payLoad = new PayPayPayLoad.PayLoadBuilder().
				setDomain(Settings.DOMAIN)
				.setEvent(event.toString())
				.setEventName(event.getObiquitusName())
				.build();
			
		ExecutorService executer = PayPayThread.startThreader();
		executer.execute(new Runnable() {
			@Override
			public synchronized void run() {
				messenger.sendMessage(payLoad);
			}
		});
		
	}

}
