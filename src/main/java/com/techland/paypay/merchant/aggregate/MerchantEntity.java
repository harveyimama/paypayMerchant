package com.techland.paypay.merchant.aggregate;

import org.springframework.stereotype.Component;

import com.techland.paypay.merchant.command.AddMerchantCommand;
import com.techland.paypay.merchant.event.MerchantAddedEvent;
@Component
public class MerchantEntity {

	public void handleCommand(AddMerchantCommand merchant) {
		MerchantAddedEvent event  = new MerchantAddedEvent(merchant.getId(),merchant.getName(),merchant.getCategory(),merchant.getEmail()
				,merchant.getPhone(),merchant.getAddress(),merchant.getRCCNumber(),merchant.getBusinessDescription());
		
		handleEvent(event);
		
	}
	
	
	public void handleEvent(MerchantAddedEvent event) {
		// TODO Auto-generated method stub
		
	}

}
