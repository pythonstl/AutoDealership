package com.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.Listings;
import com.app.repository.ListingsDAO;

/**
 * Servlet implementation class GetInventoryController
 */
@WebServlet("/GetInventoryController")
public class GetInventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInventoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: GetInventoryController.doGet()");
		HttpSession session = request.getSession();
		
		// Reads all lines in listings.txt:
		ListingsDAO dao = new ListingsDAO();
		Listings listings = new Listings(dao.read());
		
		// Adds all listings to the session:
		session.setAttribute("listings", listings);
		
		// Forwards to custInventory.jsp:
		request.getRequestDispatcher("custInventory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
