package com.techland.paypay.merchant.factories;

import com.techland.paypay.contracts.PayPayEvent;
import java.sql.Timestamp;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techland.paypay.merchant.event.UserMerchantAddedEvent;
import com.techland.paypay.merchant.event.MerchantAddedEvent;

public class EventFactory {
	static PayPayEvent paypayEvent;

	public EventFactory(PayPayEvent evt) {
		paypayEvent = evt;
	}

	@SuppressWarnings("unchecked")
	public static <T extends PayPayEvent> T getEvent(String event, String name, String eventId) {
		try {
			if ("Merchant.UserMerchantAddedEvent".equals(name)) {
				ObjectMapper mapper = new ObjectMapper();
				JsonNode actualObj = mapper.readTree(event);
				Timestamp t;
				if (actualObj.has("timestamp"))
					t = new Timestamp(actualObj.get("timestamp").asLong());
				else
					t = new Timestamp(System.currentTimeMillis());
				UserMerchantAddedEvent u = new UserMerchantAddedEvent(actualObj.get("id").asText(),
						actualObj.get("userId").asText(), actualObj.get("email").asText(),
						actualObj.get("fullname").asText(), actualObj.get("role").asText(),
						actualObj.get("username").asText(), actualObj.get("password").asText(),
						eventId == null ? actualObj.get("eventId").asText() : eventId, t);
				return (T) u;
			} else if ("Merchant.MerchantAddedEvent".equals(name)) {
				ObjectMapper mapper = new ObjectMapper();
				JsonNode actualObj = mapper.readTree(event);
				Timestamp t = new Timestamp(actualObj.get("timestamp").asLong());
				MerchantAddedEvent u = new MerchantAddedEvent(actualObj.get("id").asText(),
						actualObj.get("name").asText(), actualObj.get("category").asText(),
						actualObj.get("email").asText(), actualObj.get("phone").asText(),
						actualObj.get("address").asText(), actualObj.get("RCCNumber").asText(),
						actualObj.get("businessDescription").asText(), actualObj.get("eventId").asText(), t);
				return (T) u;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}