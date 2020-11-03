package com.example.SpringBootStripe.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StripeRefund {
	
	@Id
	private String id;

	private Long amount;
	
	private String charge;
	
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
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
