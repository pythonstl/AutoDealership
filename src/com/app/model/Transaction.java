package com.app.model;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
	protected UUID id;
	protected LocalDate saleDate;
	protected Customer customer;
	protected Listing listing;
	protected double salePrice, tax, total;
	
	// Creates NEW Transactions with unique UUIDs:
	public Transaction(Customer customer, Listing listing, double salePrice) {
		this.id = UUID.randomUUID(); //***AUTOMATIC
		this.saleDate = LocalDate.now();
		this.customer = customer;
		this.listing = listing;
		this.salePrice = salePrice;
	}
	
	public Transaction(UUID id, LocalDate saleDate, Customer customer, Listing listing, double salePrice, double tax, double total) {
		this.id = id;
		this.saleDate = saleDate;
		this.customer = customer;
		this.listing = listing;
		this.salePrice = salePrice;
		this.tax = tax;
		this.total = total;
	}



	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Listing getListing() {
		return listing;
	}
	public void setListing(Listing listing) {
		this.listing = listing;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return id + "|" + saleDate + "|" + customer + "|" + listing + "|" + salePrice + "|" + tax + "|" + total;
	}
}
