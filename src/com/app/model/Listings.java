package com.app.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Listings implements Iterable<Listing> {
	private ArrayList<Listing> listings = new ArrayList<Listing>();
	
	// to store all listings read from ListingsDAO:
	public Listings(ArrayList<Listing> listings) {
		this.listings = listings;
	}
	
	public ArrayList<Listing> getListings() {
		return listings;
	}
	public void setListings(ArrayList<Listing> listings) {
		this.listings = listings;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		listings.forEach(listing -> sb.append(listing + "\r\n"));
		return sb.toString();
	}

	@Override
	public Iterator<Listing> iterator() {
		// TODO Auto-generated method stub
		return listings.iterator();
	}
}
