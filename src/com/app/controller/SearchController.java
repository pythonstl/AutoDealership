package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: SearchController.doGet()");
		HttpSession session = request.getSession();
		ListingsDAO dao = new ListingsDAO();
		Listings listings = new Listings(dao.read());
		String model = request.getParameter("model");
		
		ArrayList<Listing> matches = new ArrayList<>();
		for (Listing listing : listings) {
			if (listing.getVehicle().getModel().equals(model)) 
				matches.add(listing);
		}
		
		boolean notFound = true;
		if (matches.isEmpty()) {
			session.setAttribute("notFound", notFound);
			Listings backToAll = new Listings(dao.read());
			session.setAttribute("listings", backToAll);
			request.getRequestDispatcher("custInventory.jsp").forward(request, response);
		}
		else {
			notFound = false;
			session.setAttribute("notFound", notFound);
			session.setAttribute("listings", matches);		
			request.getRequestDispatcher("custInventory.jsp").forward(request, response);
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
