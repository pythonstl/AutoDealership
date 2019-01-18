package com.app.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.app.utility.FileManagement.ManageFile;

// Maintains security of FileManagement.ManageFile.methods():
public interface IFileManager {
	
	// Returns an ArrayList<String[]> of tokenized lines in a text file:
	public static ArrayList<String[]> readFile(File file) throws IOException {
		return ManageFile.read(file);
	}
	
	// Prints a String of an ArrayList/table to a text file:
	public static void writeFile(File file, String printable) throws IOException {
		ManageFile.write(file, printable);
	}
}
