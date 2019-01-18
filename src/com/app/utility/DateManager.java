package com.app.utility;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

import com.app.model.Listing;
import com.app.model.Transaction;

public class DateManager {
	
	//Calculates days between two dates:
	public static long getDaysBetween(LocalDate begin, LocalDate end) {
		return ChronoUnit.DAYS.between(begin, end);
	}
	
	// Compares listing dates:
	public class ListingSort implements Comparator<Listing> {
		@Override
		public int compare(Listing ls1, Listing ls2) {
			return ls1.getListingDate().compareTo(ls2.getListingDate());
		}
	}
	
	// Compares sale dates:
	public class TransactionSort implements Comparator<Transaction> {
		@Override
		public int compare(Transaction t2, Transaction t1) {
			return t2.getSaleDate().compareTo(t1.getSaleDate());
		}
	}
}
