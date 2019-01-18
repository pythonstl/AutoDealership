package com.app.utility;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class ImageManager {
	/**
	 * @author ASK
	 * Converts an image file to byte[]:
	 */
	public static byte[] toBytes(File imageFile) throws IOException{
		BufferedImage bi = ImageIO.read(imageFile);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(bi, "jpg", outputStream);
		outputStream.flush();
		byte[] image = outputStream.toByteArray();
		outputStream.close();
		return image;
	}
	
	/**
	 * @author ASK
	 * Converts byte[] to a single Base64 String:
	 */
	public static String toBase64(byte[] bytes) throws IOException {
		//String image = new String(Base64.getEncoder().encodeToString(bytes));
		String image2 = new String(Base64.getUrlEncoder().withoutPadding().encodeToString(bytes));
		return image2;
	}
	
	/**
	 * @author ASK
	 * Generates a single Base64 String of all in ArrayList<String>, separated by ,,,,,,,:
	 */
	public static String toSingular(ArrayList<String> images){
		StringBuilder imagesAsOne = new StringBuilder();
		Iterator<String> i = images.iterator();
		while (i.hasNext()) {
			String img = i.next();
			if (!i.hasNext()) 
				imagesAsOne.append(img);
			else 
				imagesAsOne.append(img + ",,,,,,,");
		}
		return imagesAsOne.toString();
	}
	
	/**
	 * @author ASK
	 * Returns an ArrayList<String> of tokenized Strings from combined Base64 String in listings.txt:
	 */
	public static ArrayList<String> tokenize(String imagesAsOne){
		ArrayList<String> images = new ArrayList<>();
		String[] imagesDivided = imagesAsOne.split(",,,,,,,");
		for (String image : imagesDivided)
			images.add(image);
		return images;
	}
}
