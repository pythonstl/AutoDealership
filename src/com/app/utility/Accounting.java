package com.app.utility;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.app.model.Listing;

public abstract class Accounting {
	protected static final double TAXRATE = 0.10;

	public static class Calculate {
		public static double getTax(double price) {
			return price * TAXRATE;
		}
		
		public static double getTotal(double price) {
			return price + getTax(price);
		}
	}
	
	public static class Price {
		public static double getMinPriceOf(Listing listing, long days) {
			double min = listing.getAskingPrice();
			//long days = ChronoUnit.DAYS.between(listing.getListingDate(), LocalDate.now());
			if (days >= 120)
				min *= 0.9;
			return min;
		}
	}

}
