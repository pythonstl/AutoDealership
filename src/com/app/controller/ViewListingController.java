package com.app.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.Listing;
import com.app.model.Listings;
import com.app.repository.ListingsDAO;

/**
 * Servlet implementation class ViewListingController
 */
@WebServlet("/ViewListingController")
public class ViewListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewListingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: ViewListingController.doGet()");
		HttpSession session = request.getSession();
		ListingsDAO dao = new ListingsDAO();
		Listings listings = new Listings(dao.read());
		session.setAttribute("listings", listings);
		/*Listings listings = (Listings) session.getAttribute("listings");
		if (listings == null) {
			ListingsDAO dao = new ListingsDAO();
			listings = new Listings(dao.read());
		}*/
		
		// Gets the ID of the selected listing:
		UUID selected = UUID.fromString(request.getParameter("listingId"));
		
		// Matches ID to a Listing:
		for (Listing listing : listings) {
			if (listing.getId().equals(selected)) {
				session.setAttribute("listing", listing);
				request.getRequestDispatcher("custViewListing.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
