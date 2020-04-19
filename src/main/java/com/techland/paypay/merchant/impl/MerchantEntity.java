package com.techland.paypay.merchant.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techland.paypay.PayPayPayLoad;
import com.techland.paypay.config.PayPayThread;
import com.techland.paypay.merchant.command.AddMerchantCommand;
import com.techland.paypay.merchant.command.UserCommand;
import com.techland.paypay.merchant.event.MerchantAddedEvent;
import com.techland.paypay.merchant.event.UserMerchantAddedEvent;
import com.techland.paypay.merchant.helper.Constants;
import com.techland.paypay.merchant.helper.Settings;
import com.techland.paypay.messaging.PayPayMessenger;
import com.techland.paypay.util.LogFeed;
;

@Component
public final class MerchantEntity {
	@Autowired
	PayPayMessenger messenger;


	public void handleCommand(AddMerchantCommand merchant) {
		
		MerchantAddedEvent event  = new MerchantAddedEvent(merchant.getId(),merchant.getName(),merchant.getCategory(),merchant.getEmail()
				,merchant.getPhone(),merchant.getAddress(),merchant.getRCCNumber(),merchant.getBusinessDescription());
	
		List<UserCommand> users = merchant.getUsers();
		handleEvent(event,users);
		
		LogFeed logfeed = new LogFeed.LogProcessor()  
				.setInfo(Constants.SUCESS_MESSAGE)
				.setClazz(MerchantEntity.class)
				.setDomain(Settings.DOMAIN)
				.setOtherInfo(merchant.toString())
				.build(); 
		logfeed.process();
		
	}
	
	
	private void handleEvent(MerchantAddedEvent event, List<UserCommand> users) {
		
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
				
				for(UserCommand user : users)
				{
					
					UserMerchantAddedEvent userEvent  = new UserMerchantAddedEvent(event.getId(), user.getId(),  user.getEmail(),
							user.getFullname(),user.getRole(),user.getUsername(),user.getPassword());
					handleEvent(userEvent);
				}
			}
		});
		
	}
	
private void handleEvent(UserMerchantAddedEvent user) {
			
		PayPayPayLoad payLoad = new PayPayPayLoad.PayLoadBuilder().
				setDomain(Settings.DOMAIN)
				.setEvent(user.toString())
				.setEventName(user.getObiquitusName())
				.build();
	
				messenger.sendMessage(payLoad);
		
		
	}

private String getUserCommand(List<UserCommand> users) {
	int counter = users.size();
	String userCmd = "[";
	for (UserCommand usr : users) {
		userCmd = userCmd+usr.toString();
		if(counter>1)
			userCmd = userCmd+",";
		counter--;
	}

	return userCmd+"]";

}

}
