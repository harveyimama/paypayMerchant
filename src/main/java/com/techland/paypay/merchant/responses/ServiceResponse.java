package com.techland.paypay.merchant.responses;

import org.springframework.stereotype.Component;

@Component
public class ServiceResponse {
private String message;
private int responseCode;
private boolean success;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getResponseCode() {
	return responseCode;
}
public void setResponseCode(int responseCode) {
	this.responseCode = responseCode;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
 
	
	
}
