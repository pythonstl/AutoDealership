package com.app.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

abstract class FileManagement {
	
	static final class ManageFile {
		
		// Returns an ArrayList<String[]> of tokenized lines in a text file:
		static ArrayList<String[]> read(File file) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			ArrayList<String[]> lines = new ArrayList<>();
			while((line = br.readLine()) != null) {
				String[] tokenized = line.split("\\|");
				lines.add(tokenized);
			}
			br.close();
			return lines;
		}
		
		// Prints a String of an ArrayList (i.e., table) to a text file:
		static void write(File file, String printable) throws IOException {
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(printable);
			bw.flush();
			bw.close();
		}	
	}
}