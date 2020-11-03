package com.example.SpringBootStripe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.exception.CardException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.StripeResponse;

import io.micrometer.core.ipc.http.HttpSender.Response;

import com.example.SpringBootStripe.model.StripeCard;
import com.example.SpringBootStripe.model.StripeCustomer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class CustomerService {
	
	public static String key = "sk_test_uTAM1qndRDbiJRowe8dJf6x9";

	public String addCustomer(StripeCustomer cus) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException, JsonProcessingException {
		Stripe.apiKey = key;
		
		Map<String, Object> customerParams = new HashMap<String, Object>();
		
	    ObjectMapper mapper = new ObjectMapper();
	     	      
	    Customer customer = new Customer();
	      
	    StripeResponse response = null;
	    try {
	    	customerParams.put("description", cus.getDescription());
	  		
			customer = Customer.create(customerParams);
						
		    response = customer.getLastResponse();
						
		}
	    catch (StripeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    return response.body();
		
	}
	
	public String retrieveCustomer(String customerId) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		Stripe.apiKey = key;
		// TODO Auto-generated method stub
		Customer c = null;
	    StripeResponse response = null;

		try {
			c = Customer.retrieve(customerId);
		    response = c.getLastResponse();
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.body();
	}
	
	
	public String addCard(StripeCard sCard, String cid) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		Stripe.apiKey = key;
		
		Map<String, Object> retrieveParams = new HashMap<String, Object>();
		List<String> expandList = new ArrayList<>();
		
		Map<String, Object> params = new HashMap<String, Object>();
		Customer customer = null;
		Card card = null;		
		StripeResponse response = null;

		
		try {
			expandList.add("sources");
			retrieveParams.put("expand", expandList);
			customer = Customer.retrieve(cid, retrieveParams, null);
			params.put("source", "tok_mastercard");
			card = (Card) customer.getSources().create(params);
			response = card.getLastResponse();

		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.body();
	}
	

	
	
	
}
