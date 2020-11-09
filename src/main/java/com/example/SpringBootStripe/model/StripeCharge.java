package com.example.SpringBootStripe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stripe_charge")
public class StripeCharge {
	
	@Id
	private String id;

	private Long amount;
	private Long amount_captured;
	private Long amount_refunded;
	private Long application_fee_amount;
	private String authorization_code;
	private String calculated_statement_descriptor;
	private Boolean captured;
	private Boolean created;
	private String currency;
	private String description;
	private Boolean disputed;
	private String failure_code;
	private String failure_message;
	private Boolean livemode;
	private String object;
	private Boolean paid;
	private String payment_method;
	private String receipt_number;
	private String receipt_url;
	private Boolean refunded;
	private String statement_descriptor;
	private String statement_descriptor_suffix;
	private String status;
	private String customerId;
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public Long getAmountCaptured() {
		return amount_captured;
	}
	public void setAmountCaptured(Long amount_captured) {
		this.amount_captured = amount_captured;
	}
	public Long getAmountRefunded() {
		return amount_refunded;
	}
	public void setAmountRefunded(Long amount_refunded) {
		this.amount_refunded = amount_refunded;
	}
	public String getCalculatedStatementDescriptor() {
		return calculated_statement_descriptor;
	}
	public void setCalculatedStatementDescriptor(String calculated_statement_descriptor) {
		this.calculated_statement_descriptor = calculated_statement_descriptor;
	}
	public Boolean getCaptured() {
		return captured;
	}
	public void setCaptured(Boolean captured) {
		this.captured = captured;
	}
	public Boolean getCreated() {
		return created;
	}
	public void setCreated(Boolean created) {
		this.created = created;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDisputed() {
		return disputed;
	}
	public void setDisputed(Boolean disputed) {
		this.disputed = disputed;
	}
	
	
}
