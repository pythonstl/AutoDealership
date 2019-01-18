package com.app.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.admin.model.Administrator;
import com.app.model.Listing;
import com.app.model.Listings;
import com.app.repository.ListingsDAO;

/**
 * Servlet implementation class AdminEditController
 */
@WebServlet("/AdminEditController")
public class AdminEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminEditController.doGet()");
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		
		// Checks if logged in:
		if (admin == null || admin.isLoggedIn() == false) 
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		
		// Matches selected Listing with a Listing in Listings:
		UUID listingId = UUID.fromString(request.getParameter("listingId"));
		Listings listings = (Listings) session.getAttribute("listings");
		for (Listing listing : listings) {
			if (listing.getId().equals(listingId)) 
				session.setAttribute("listing", listing);			
		}
		
		// Forwards to adminEdit.jsp:
		request.getRequestDispatcher("adminEditListing.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminEditController.doPost()");
		HttpSession session = request.getSession();
		Listing listing = (Listing) session.getAttribute("listing");
		System.out.println("Editing listing: " + listing.getId());
		
		// Removes current information from listings.txt:
		ListingsDAO dao = new ListingsDAO();
		dao.removeListing(listing);
		
		// Gets Base64 Strings:
		ArrayList<String> images = new ArrayList<>();
		String[] imageValues = request.getParameterValues("images");
		for (String image : imageValues)
			images.add(image);
		listing.getVehicle().setImages(images);
		
		// Gets everything else:
		listing.getVehicle().setCondition(Boolean.parseBoolean(request.getParameter("condition")));
		listing.getVehicle().setYear(request.getParameter("year"));
		listing.getVehicle().setMake(request.getParameter("make"));
		listing.getVehicle().setModel(request.getParameter("model"));
		listing.getVehicle().setColor(request.getParameter("color"));
		listing.getVehicle().setMileage(request.getParameter("mileage"));
		listing.getVehicle().setDrive(request.getParameter("drive"));
		listing.getVehicle().setTransmission(request.getParameter("transmission"));
		listing.getVehicle().setFuel(request.getParameter("fuel"));
		listing.getVehicle().setMpg(request.getParameter("mpg"));
		listing.getVehicle().setInterior(request.getParameter("interior"));
		listing.getVehicle().setDescription(request.getParameter("description"));
		listing.setAskingPrice(Double.parseDouble(request.getParameter("askingPrice")));
		
		// Re-sets the session's "listing" attribute:
		session.setAttribute("listing", listing);
		
		// Adds the current information to listings.txt:
		dao.addToListings(listing);
		
		// Forwards to AdminGetInventoryController:
		request.getRequestDispatcher("AdminGetInventoryController").forward(request, response);
	}

}
