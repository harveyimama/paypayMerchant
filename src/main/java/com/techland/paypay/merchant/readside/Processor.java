package com.techland.paypay.merchant.readside;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techland.paypay.user.aggregates.EventSourcer;
import com.techland.paypay.user.impl.UserState;
import com.techland.paypay.user.persistence.User;
import com.techland.paypay.user.persistence.UserRepository;

@Service
public class Processor {
	
	private MerchantRepository merchantRepo;
	
	Processor(MerchantRepository merchantRepo)
	{
		this.merchantRepo = merchantRepo;
	}

	
	

}
