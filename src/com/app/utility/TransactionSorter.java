package com.app.utility;

import java.util.Comparator;

import com.app.model.Transaction;

public class TransactionSorter implements Comparator<Transaction> {
	@Override
	public int compare(Transaction t2, Transaction t1) {
		return t2.getSaleDate().compareTo(t1.getSaleDate());
	}
}

