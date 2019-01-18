package com.app.repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import com.app.model.Listing;
import com.app.model.Listings;
import com.app.model.Vehicle;
import com.app.utility.IFileManager;
import com.app.utility.ImageManager;
import com.app.utility.ListingSorter;

public final class ListingsDAO extends AbstractRepository implements IFileManager {
	private File FILE = new File(super.getFilePath(), "listings.txt");

	/** READ
	 * @author ASK
	 * Reads listings.txt and returns ArrayList<Listing>:
	 * @throws IOException 
	 */
	@Override
	public final ArrayList<Listing> read() throws IOException {
		ArrayList<Listing> listingsAL = new ArrayList<>();	
		ArrayList<String[]> lines; // *****DO NOT CHANGE THIS LINE.*****
		lines = IFileManager.readFile(FILE);
		for (String[] line : lines) {
			listingsAL.add(stringToListing(line));
		}
		return listingsAL;
	}
	
	/** STRING_TO_LISTINGS
	 * @author ASK
	 * Reads a String[] and creates a single Listing:
	 */
	private Listing stringToListing(String[] line) {
			UUID id = UUID.fromString(line[0]);
			UUID vin = UUID.fromString(line[1]);
			ArrayList<String> images = ImageManager.tokenize(line[2]);
			Boolean condition = Boolean.valueOf(line[3]);
			String year = line[4];
			String make = line[5];
			String model = line[6];
			String color = line[7];
			String mileage = line[8];
			String drive = line[9];
			String transmission = line[10];
			String fuel = line[11];
			String mpg = line[12];
			String interior = line[13];
			String description = line[14];
			double askingPrice = Double.parseDouble(line[15]);
			LocalDate listingDate = LocalDate.parse(line[16]);
			long daysOnMarket = Long.parseLong(line[17]);
			Vehicle vehicle = new Vehicle(vin, images, condition, year, make, model, color, mileage, drive, 
					transmission, fuel, mpg, interior, description);
			Listing listing = new Listing(id, vehicle, askingPrice, listingDate, daysOnMarket);
			return listing;
	}

	/** 
	 * @author ASK
	 * Adds a new Listing:
	 */
	public final void addToListings(Listing listing) throws IOException {
		ArrayList<Listing> listingsAL = read();
		listingsAL.add(listing);
		if (listingsAL.size() > 1)
			sort(listingsAL);
		else {
			Listings listings = new Listings(listingsAL);
			write(listings);
		}
	}
	
	/** 
	 * @author ASK
	 * Sorts Listings, oldest first:
	 */
	private void sort(ArrayList<Listing> listingsAL) throws IOException{
		listingsAL.sort(new ListingSorter());
		Listings listings = new Listings(listingsAL);
		write(listings);
	}
	
	/** 
	 * @author ASK
	 * Saves Listings to listings.txt:
	 */
	private void write(Listings listings) throws IOException {
		String printable = listings.toString();
		IFileManager.writeFile(FILE, printable);
	}

	/** 
	 * @author ASK
	 * Removes Listings from listings.txt:
	 */
	public final void removeListing(Listing listing) throws IOException {
		ArrayList<Listing> listings = read();
		Iterator<Listing> i = listings.iterator();
		while (i.hasNext()) {
			Listing ls = (Listing) i.next();
			if (ls.getId().equals(listing.getId()))
				i.remove();
		}
		sort(listings);
	}
	
}
