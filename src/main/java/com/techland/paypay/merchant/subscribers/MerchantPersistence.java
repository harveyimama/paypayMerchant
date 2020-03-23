package com.techland.paypay.merchant.subscribers;

import com.techland.paypay.contracts.PayPayState;
import com.techland.paypay.contracts.StateSubscriber;
import com.techland.paypay.contracts.TechLandSubscriber;
import com.techland.paypay.persistence.StateFailure;
import com.techland.paypay.persistence.StateFailureRepository;
@TechLandSubscriber(events = { "MerchantAddedEvent" }, isstate = true)
public class MerchantPersistence implements StateSubscriber{

	@Override
	public boolean isState() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleError(PayPayState paypayState, StateFailure failure, StateFailureRepository failureRepo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleSuccess(PayPayState paypayState, StateFailure failure, StateFailureRepository failureRepo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(PayPayState paypayState) {
		// TODO Auto-generated method stub
		
	}

}
