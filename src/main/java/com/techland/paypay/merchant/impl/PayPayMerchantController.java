package com.techland.paypay.merchant.impl;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.techland.paypay.merchant.helper.Constants;
import com.techland.paypay.merchant.commands.AddMerchantCommand;
import com.techland.paypay.merchant.readside.Processor;
import com.techland.paypay.merchant.responses.ServiceResponse;
import com.techland.paypay.util.LogFeed;



@Controller
public class PayPayMerchantController {
	
	private ServiceResponse resp;
	private LogFeed logfeed;
	private MerhantEntity merchantEntity;
	private Processor processor;
	


	public PayPayMerchantController(ServiceResponse resp,LogFeed logfeed,Processor processor,MerhantEntity merchantEntity) {
		this.resp = resp;
		this.logfeed = logfeed;
		this.processor = processor;
		this.merchantEntity = merchantEntity;
		}
	
	@PostMapping(path = "/api/merchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResponse CreateMerchant(@RequestBody final AddMerchantCommand merchant) {
		
		try {
			
			
			merchantEntity.handleCommand(merchant);

			resp.setMessaged(Constants.SUCESS_MESSAGE);
			resp.setResponseCode(Constants.SUCESS_CODE);
			resp.setSuccess(true);
			
			logfeed.getInstance(Constants.SUCESS_MESSAGE,PayPayMerchantController.class,merchant.toString()).process();
		

		} catch (Exception e) {
		e.printStackTrace();
			resp.setMessaged(Constants.SERVER_ERROR);
			resp.setResponseCode(Constants.SERVER_ERROR_CODE);
			resp.setSuccess(false);
			
			logfeed.getInstance(Constants.SERVER_ERROR,PayPayMerchantController.class,merchant.toString(),e.getMessage()).process();
		
		}
		return resp;
	}

}
