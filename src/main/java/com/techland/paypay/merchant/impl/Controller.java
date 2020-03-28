package com.techland.paypay.merchant.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techland.paypay.merchant.helper.Settings;
import com.techland.paypay.merchant.command.AddMerchantCommand;
import com.techland.paypay.merchant.helper.Constants;
import com.techland.paypay.merchant.persistence.Processor;
import com.techland.paypay.merchant.responses.ServiceResponse;
import com.techland.paypay.util.LogFeed;

           

@RestController
public class Controller {
	
	@Autowired
	private ServiceResponse resp;
	@Autowired
	private MerchantEntity merchantEntity;
	@Autowired
	private Processor processor;
	@Autowired
	private LogFeed logfeed;
	
	
	

	@PostMapping(path = "/api/merchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResponse CreateUser(@RequestBody final AddMerchantCommand user) {
		try {
			
			merchantEntity.handleCommand(user);

			resp.setMessage(Constants.SUCESS_MESSAGE);
			resp.setResponseCode(Constants.SUCESS_CODE);
			resp.setSuccess(true);
			
			logfeed.getInstance(Constants.SUCESS_MESSAGE,Controller.class,Settings.DOMAIN,user.toString()).process();
		

		} catch (Exception e) {
		e.printStackTrace();
			resp.setMessage(Constants.SERVER_ERROR);
			resp.setResponseCode(Constants.SERVER_ERROR_CODE);
			resp.setSuccess(false);
			
			logfeed.getInstance(Constants.SERVER_ERROR,Controller.class,Settings.DOMAIN,user.toString(),e.getMessage()).process();
		
		}
		return resp;
	}
	

}
