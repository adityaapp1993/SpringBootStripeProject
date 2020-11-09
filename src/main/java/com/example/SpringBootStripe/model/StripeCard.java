package com.example.SpringBootStripe.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StripeCard {

	@Id
	private String id;
	
	private HashMap<String, Object> metadata;

	private HashMap<String, Object> cardDetails;
	
	private String customerId;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public HashMap<String, Object> getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(HashMap<String, Object> cardDetails) {
		this.cardDetails = cardDetails;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public HashMap<String, Object> getMetadata() {
		return metadata;
	}
	public void setMetadata(HashMap<String, Object> metadata) {
		this.metadata = metadata;
	}
	
	
	

}
