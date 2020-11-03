package com.example.SpringBootStripe.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.SpringBootStripe.model.StripeRefund;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
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
	public static String key = "sk_test_uTAM1qndRDbiJRowe8dJf6x9";

	public String createRefund(StripeRefund refund) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		Stripe.apiKey = key;
		Map<String, Object> refundParams = new HashMap<String, Object>();
		Refund rfnd = null;
	      StripeResponse response = null;

		try {
			refundParams.put("charge",refund.getCharge());
				rfnd = Refund.create(refundParams);
			response = rfnd.getLastResponse();
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.body();
	}
	
	

}
