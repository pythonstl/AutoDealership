package com.app.admin.controller;

import java.io.IOException;
import java.time.LocalDate;

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
import com.app.utility.DateManager;

/**
 * Servlet implementation class AdminGetInventoryController
 */
@WebServlet("/AdminGetInventoryController")
public class AdminGetInventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetInventoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Verifies whether administrator is logged in:
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminGetInventoryController.doGet()");
		HttpSession session = request.getSession();
		// YOU MAY NEED TO CAST ANOTHER SESSION ADMIN HERE, AS IN doPOST BELOW***************************************

		// Reads all lines in listings.txt:
		ListingsDAO dao = new ListingsDAO();
		Listings listings = new Listings(dao.read());
		for (Listing listing : listings)
			listing.setDaysOnMarket(DateManager.getDaysBetween(listing.getListingDate(), LocalDate.now()));
		
		// Adds all listings to session:
		session.setAttribute("listings", listings);
		
		// Forwards to adminInventory.jsp (to view all current listings):
		request.getRequestDispatcher("adminInventory.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminGetInventoryController.doPost()");
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		
		// Checks if logged in:
		if (admin == null || admin.isLoggedIn() == false) 
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		else
			doGet(request, response);
	}

}
