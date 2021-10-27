package com.company.entity;

public class Customer {

	private Integer customerId;
	private String email;

	public Customer(Integer customerId, String email) {
		super();
		this.customerId = customerId;
		this.email = email;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
