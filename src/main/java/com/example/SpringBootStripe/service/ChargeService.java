package com.example.SpringBootStripe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.net.StripeResponse;
import com.example.SpringBootStripe.Properties.SpringBootStripeProperties;
import com.example.SpringBootStripe.model.StripeCharge;
import com.stripe.Stripe;
import org.springframework.stereotype.Service;

@Service
public class ChargeService 
{

public String addCharge(StripeCharge charge) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
		Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		Charge c = new Charge();
		StripeResponse response = null;
		try {
			chargeParams.put("amount", charge.getAmount() );
			chargeParams.put("currency", charge.getCurrency());
			chargeParams.put("source", "tok_amex");
			chargeParams.put("description", charge.getDescription());
			c = Charge.create(chargeParams);
			response = c.getLastResponse();
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (response != null)
			return response.body();
		else return null;
	}	


public String retrieveCharge(String cid) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
		Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
		// TODO Auto-generated method stub
		Charge c = new Charge();;
		StripeResponse response = null;
		try {
			c = Charge.retrieve(cid);
			response = c.getLastResponse();
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (response != null)
			return response.body();
		else return null;
		
	}
}
