package com.app.utility;

import java.util.Comparator;

import com.app.model.Listing;

public class ListingSorter implements Comparator<Listing> {
	// Compares listing dates:
	@Override
	public int compare(Listing ls1, Listing ls2) {
		return ls1.getListingDate().compareTo(ls2.getListingDate());
	}
}
