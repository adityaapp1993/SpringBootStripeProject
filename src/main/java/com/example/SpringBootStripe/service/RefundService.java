package com.example.SpringBootStripe.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.SpringBootStripe.Properties.SpringBootStripeProperties;
import com.example.SpringBootStripe.model.StripeRefund;
import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Refund;
import com.stripe.net.StripeResponse;

@Service
public class RefundService
{
	public String createRefund(StripeRefund refund) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
		Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
		Map<String, Object> refundParams = new HashMap<String, Object>();
		Refund rfnd = null;
	    StripeResponse response = null;
		try {
			refundParams.put("charge",refund.getChargeId());
			rfnd = Refund.create(refundParams);
			response = rfnd.getLastResponse();
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (response != null)
			return response.body();
		else return null;
	}
	
	

}
