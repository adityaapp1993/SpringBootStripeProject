package com.example.SpringBootStripe.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StripeCard {

	@Id
	private String id;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
