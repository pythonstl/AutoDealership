package com.app.model;

import java.util.UUID;

public class Customer {
	protected UUID customerId;
	protected String firstName, lastName;
	protected Address address;
	
	// Creates a NEW Customer with a unique UUID:
	public Customer(String firstName, String lastName, 
			String street, String city, String state, String zip, String telephone, String email) {
		this.customerId = UUID.randomUUID(); //***AUTOMATIC
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = new Address(street, city, state, zip, telephone, email);
	}
	
	// Creates an EXISTING customer: 	
	public Customer(UUID customerId, String firstName, String lastName, Address address) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public UUID getCustomerId() {
		return customerId;
	}
	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return customerId + "|" + firstName + "|" + lastName + "|" + address;
	}
}
