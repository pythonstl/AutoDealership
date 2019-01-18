package com.app.admin.controller;

import java.io.IOException;
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
 * Servlet implementation class AdminDeleteController
 */
@WebServlet("/AdminDeleteController")
public class AdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminDeleteController.doGet()");
		HttpSession session = request.getSession();
		
		// Checks if logged in:
		Administrator admin = (Administrator) session.getAttribute("admin");
		if (admin == null)
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		
		// Compares Listing ID of every ID in Listings to Listing from adminInventory.jsp:
		Listings listings = (Listings) session.getAttribute("listings");
		UUID listingId = UUID.fromString(request.getParameter("listingId"));
		for (Listing listing : listings) {
			if (listing.getId().equals(listingId))
				session.setAttribute("listingToDelete", listing);
		}
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminDeleteController.doPost()");
		HttpSession session = request.getSession();
		
		// Makes sure the listing is not null:
		Listing listingToDelete = (Listing) session.getAttribute("listingToDelete");
		if (listingToDelete == null)
			request.getRequestDispatcher("AdminViewInventoryController").forward(request, response);
		
		// Removes the listing:
		ListingsDAO dao = new ListingsDAO();
		dao.removeListing(listingToDelete);
		
		// Forwards back to inventory:
		request.getRequestDispatcher("AdminGetInventoryController").forward(request, response);
	}

}
