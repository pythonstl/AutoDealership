package com.app.repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.app.model.Address;
import com.app.model.Customer;
import com.app.model.Listing;
import com.app.model.Transaction;
import com.app.model.Transactions;
import com.app.model.Vehicle;
import com.app.utility.IFileManager;
import com.app.utility.ImageManager;
import com.app.utility.TransactionSorter;

public class TransactionsDAO extends AbstractRepository {
	private File FILE = new File(super.getFilePath(), "transactions.txt");

	/**
	 * @author ASK
	 * Reads transactions.txt and returns ArrayList<Transaction> of transactions.
	 * @throws IOException 
	 */
	@Override
	public final ArrayList<Transaction> read() throws IOException {
		ArrayList<Transaction> transactionsAL = new ArrayList<>();	
		ArrayList<String[]> lines; // *****DO NOT CHANGE THIS LINE.*****
		lines = IFileManager.readFile(FILE);
		for (String[] line : lines) 
			transactionsAL.add(stringToTransaction(line));
		return transactionsAL;
	}
	
	/** 
	 * @author ASK
	 * Converts a String[] into one Transaction:
	 */
	private Transaction stringToTransaction(String[] line) {
		return new Transaction (
				UUID.fromString(line[0]),
				LocalDate.parse(line[1]),
				new Customer (UUID.fromString(line[2]), line[3], line[4], 
						new Address (line[5], line[6], line[7], line[8], line[9], line[10])),
				new Listing (UUID.fromString(line[11]),
						new Vehicle (UUID.fromString(line[12]),
								ImageManager.tokenize(line[13]),
								Boolean.valueOf(line[14]),
								line[15], line[16], line[17], line[18], line[19], line[20],
								line[21], line[22], line[23], line[24], line[25]), 
						Double.parseDouble(line[26]),
						LocalDate.parse(line[27]),
						Long.parseLong(line[28])),
				Double.parseDouble(line[29]),
				Double.parseDouble(line[30]),
				Double.parseDouble(line[31]));
	}
		
	/** 
	 * @author ASK
	 * Adds a new Transaction:
	 */
	public final void addToTransactions(Transaction transaction) throws IOException {
		ArrayList<Transaction> transactionsAL = read();
		transactionsAL.add(transaction);
		if (transactionsAL.size() > 1)
			sort(transactionsAL);
		else {
			Transactions transactions = new Transactions(transactionsAL);
			write(transactions);
		}
	}
	
	/** 
	 * @author ASK
	 * Sorts the Transactions, oldest first:
	 */
	private void sort(ArrayList<Transaction> transactionsAL) throws IOException {
		transactionsAL.sort(new TransactionSorter());
		Transactions transactions = new Transactions(transactionsAL);
		write(transactions);
	}
	
	/** 
	 * @author ASK
	 * Writes an ArrayList<Transaction> to transactions.txt:
	 */
	private void write(Transactions transactions) throws IOException {
		String printable = transactions.toString();
		IFileManager.writeFile(FILE, printable);
	}
	
}
