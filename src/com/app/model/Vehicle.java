package com.app.model;

import java.util.ArrayList;
import java.util.UUID;

import com.app.utility.ImageManager;

public class Vehicle {
	protected UUID vin;
	protected ArrayList<String> images;
	protected boolean condition;
	protected String year, make, model, color, mileage, drive, transmission, fuel, mpg, interior, description;
	
	// Generates a NEW vehicle object with unique VIN:
	public Vehicle (
			ArrayList<String> images, boolean condition, String year, String make, String model, String color, 
			String mileage, String drive, String transmission, String fuel, String mpg, String interior, String description	) {
		this.vin = UUID.randomUUID(); //***
		this.images = images;
		this.condition = condition;
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.drive = drive;
		this.transmission = transmission;
		this.fuel = fuel;
		this.mpg = mpg;
		this.interior = interior;
		this.description = description;
	}
	
	// Generates an EXISTING vehicle with EXISTING VIN:
	public Vehicle(UUID vin, ArrayList<String> images, boolean condition, String year, String make, String model,
			String color, String mileage, String drive, String transmission, String fuel, String mpg, String interior,
			String description) {
		this.vin = vin;
		this.images = images;
		this.condition = condition;
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.drive = drive;
		this.transmission = transmission;
		this.fuel = fuel;
		this.mpg = mpg;
		this.interior = interior;
		this.description = description;
	}

	public UUID getVin() {
		return vin;
	}
	public void setVin(UUID vin) {
		this.vin = vin;
	}
	public ArrayList<String> getImages() {
		return images;
	}
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	public boolean getCondition() {
		return condition;
	}
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getMpg() {
		return mpg;
	}
	public void setMpg(String mpg) {
		this.mpg = mpg;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return vin + "|" + ImageManager.toSingular(images) + "|" + condition + "|" + year + "|"
				+ make + "|" + model + "|" + color + "|" + mileage + "|" + drive
				+ "|" + transmission + "|" + fuel + "|" + mpg + "|" + interior
				+ "|" + description;
	}
}
