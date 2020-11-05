
package com.example.SpringBootStripe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStripe.model.StripeCharge;
import com.example.SpringBootStripe.service.ChargeService;

import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@RestController	
public class ChargeController {
	@Autowired
		private ChargeService chargeService;

		@PostMapping(value="/v1/charges")
		public String createCharge(@RequestBody StripeCharge charge) throws AuthenticationException, InvalidRequestException, CardException, ApiConnectionException, ApiException {
			return chargeService.addCharge(charge);
		}

		@GetMapping(value="/v1/charges/{cid}")
		public String retrieveCharge(@PathVariable String cid) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
			return chargeService.retrieveCharge(cid);
		}
}
