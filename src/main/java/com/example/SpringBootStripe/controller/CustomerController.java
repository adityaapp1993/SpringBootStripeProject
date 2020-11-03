package com.example.SpringBootStripe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStripe.model.StripeCard;
import com.example.SpringBootStripe.model.StripeCustomer;
import com.example.SpringBootStripe.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;
import com.stripe.net.StripeResponse;
import com.stripe.model.Card;



@RestController	
public class CustomerController {
	@Autowired
		private CustomerService customerService;
	
		@GetMapping(value="/v1/customers/{cid}")
		public String retrieveCustomer(@PathVariable String cid) throws AuthenticationException, InvalidRequestException, APIException, CardException, APIConnectionException {
			return customerService.retrieveCustomer(cid);
		}
		

		@PostMapping(value="/v1/customers")
		public String addCustomer(@RequestBody StripeCustomer cus) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException, JsonProcessingException {
			return customerService.addCustomer(cus);
		}

		
		@PostMapping(value="/v1/customers/{cid}/sources")
		public String addCard(@RequestBody StripeCard card, @PathVariable String cid) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
			return customerService.addCard(card, cid);
		}
		
		
	

}

