package com.app.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Transactions implements Iterable<Transaction> {
	private ArrayList<Transaction> transactions;

	// To store all transactions read from TransactionsDAO:
	public Transactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		transactions.forEach(transaction -> sb.append(transaction + "\r\n"));
		return sb.toString();
	}

	@Override
	public Iterator<Transaction> iterator() {
		return transactions.iterator();
	}
}
