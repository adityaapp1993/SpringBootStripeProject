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
import com.stripe.model.ExternalAccountCollection;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.StripeResponse;

import io.micrometer.core.ipc.http.HttpSender.Response;

import com.example.SpringBootStripe.Properties.SpringBootStripeProperties;
import com.example.SpringBootStripe.model.StripeCard;
import com.example.SpringBootStripe.model.StripeCustomer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.stripe.Stripe;

@Service
public class CustomerService {
	
	public String addCustomer(StripeCustomer cus) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException, JsonProcessingException {
		
		Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
		Map<String, Object> customerParams = new HashMap<String, Object>();
	    ObjectMapper mapper = new ObjectMapper();
	    Customer customer = new Customer();
	    Card c = new Card();
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
	    if (response != null)
			return response.body();
		else return null;
		
	}
	
	public String retrieveCustomer(String customerId) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
		Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
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
		if (response != null)
			return response.body();
		else return null;
	}
	
	
	public String addCard(StripeCard sCard, String cid) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
		Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
		
		Map<String, Object> retrieveParams = new HashMap<String, Object>();
		List<String> expandList = new ArrayList<>();
		
		Map<String, Object> params = new HashMap<String, Object>();
		Card card = new Card();		
		StripeResponse response = null;
		
		try {
			expandList.add("sources");
			retrieveParams.put("expand", expandList);
			Customer customer = Customer.retrieve(cid, retrieveParams, null);
			params.put("source", "tok_mastercard");
			card = (Card) customer.getSources().create(params);				
			response = card.getLastResponse();

		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (response != null)
			return response.body();
		else return null;
	}
	

	
	
	
}
