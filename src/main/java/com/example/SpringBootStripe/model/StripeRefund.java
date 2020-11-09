package com.example.SpringBootStripe.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StripeRefund {
	
	@Id
	private String id;

	private Long amount;
	
	private String chargeId;
	
	public String getChargeId() {
		return chargeId;
	}
	public void setCharge(String chargeId) {
		this.chargeId = chargeId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	

}
