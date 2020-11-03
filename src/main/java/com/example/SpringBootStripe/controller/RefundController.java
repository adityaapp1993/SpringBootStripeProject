package com.example.SpringBootStripe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStripe.model.StripeRefund;
import com.example.SpringBootStripe.service.RefundService;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Refund;

@RestController	
public class RefundController {
	@Autowired
		private RefundService refundService;

		@PostMapping(value="/v1/refunds")
		public String createRefund(@RequestBody StripeRefund refund) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
			return refundService.createRefund(refund);
		}
}	

