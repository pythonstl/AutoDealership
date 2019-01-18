package com.app.model;

import java.time.LocalDate;
import java.util.UUID;

public class Listing {
	protected UUID id;
	protected Vehicle vehicle;
	protected double askingPrice;
	protected LocalDate listingDate;
	protected long daysOnMarket;
		
	// Generates a NEW Listing with a unique UUID:
	public Listing(Vehicle vehicle, double askingPrice) {
		this.id = UUID.randomUUID(); //***AUTOMATIC
		this.vehicle = vehicle;
		this.askingPrice = askingPrice;
		this.listingDate = LocalDate.now();
	}
	
	// Generates an EXISTING Listing:
	public Listing(UUID id, Vehicle vehicle, double askingPrice, LocalDate listingDate, long daysOnMarket) {
		this.id = id;
		this.vehicle = vehicle;
		this.askingPrice = askingPrice;
		this.listingDate = listingDate;
		this.daysOnMarket = daysOnMarket;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID uuid) {
		this.id = uuid;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public double getAskingPrice() {
		return askingPrice;
	}
	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}
	public LocalDate getListingDate() {
		return listingDate;
	}
	public void setListingDate(LocalDate listingDate) {
		this.listingDate = listingDate;
	}
	public long getDaysOnMarket() {
		return daysOnMarket;
	}
	public void setDaysOnMarket(long daysOnMarket) {
		this.daysOnMarket = daysOnMarket;
	}

	@Override
	public String toString() {
		return id + "|" + vehicle + "|" + askingPrice + "|"	+ listingDate + "|" + daysOnMarket;
	}
}
