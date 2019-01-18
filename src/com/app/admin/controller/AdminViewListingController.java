package com.app.admin.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import com.app.utility.DateManager;

/**
 * Servlet implementation class AdminViewListingController
 */
@WebServlet("/AdminViewListingController")
public class AdminViewListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewListingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminViewListingController.doGet()");
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		
		// Checks if logged in:
		if (admin == null || admin.isLoggedIn() == false) 
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		
		UUID listingId = UUID.fromString(request.getParameter("listingId"));
		
		// Matches selected Listing with a Listing in Listings:
		Listings listings = (Listings) session.getAttribute("listings");
		for (Listing listing : listings) {
			if (listing.getId().equals(listingId)) {
				// Updates days on market:
				listing.setDaysOnMarket(DateManager.getDaysBetween(LocalDate.now(), listing.getListingDate()));
				session.setAttribute("listing", listing);
			}
		}
		
		// Forwards to vehicle's page:
		request.getRequestDispatcher("adminViewListing.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
