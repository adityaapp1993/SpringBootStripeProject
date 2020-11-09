package com.example.SpringBootStripe.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stripe.model.Address;

@Entity
public class StripeCustomer  {
	
	@Id
	private String id;
	
	private String object;
	
	private String description;
	
	private String email;
	
	private String name;
		
	private HashMap<String,Object> address;
	
	public HashMap<String,Object> getAddress() {
		return address;
	}
	public void setAddress(HashMap<String,Object> address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public StripeCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
