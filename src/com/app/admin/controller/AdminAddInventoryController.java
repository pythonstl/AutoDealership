package com.app.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.admin.model.Administrator;
import com.app.model.Listing;
import com.app.model.Vehicle;
import com.app.repository.ListingsDAO;
import com.app.utility.ImageManager;

/**
 * Servlet implementation class AdminAddInventoryController
 */
@WebServlet("/AdminAddInventoryController")
public class AdminAddInventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddInventoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AdminGetInventoryController").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		
		// Checks if logged in:
		if (admin == null || admin.isLoggedIn() == false) 
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		
		// Gets Base64 Strings:
		ArrayList<String> images = new ArrayList<>();
		String[] imageValues = request.getParameterValues("images");
		for (String image : imageValues) {
			String f = image.replaceAll("\\\\", "\\\\\\\\");
			File file = new File(f);
			byte[] bytes = ImageManager.toBytes(file);
			String converted = ImageManager.toBase64(bytes);
			images.add(converted);
		}
		// Gets everything else:
		Boolean condition = Boolean.parseBoolean(request.getParameter("condition"));
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String mileage = request.getParameter("mileage");
		String drive = request.getParameter("drive");
		String transmission = request.getParameter("transmission");
		String fuel = request.getParameter("fuel");
		String mpg = request.getParameter("mpg");
		String interior = request.getParameter("interior");
		String description = request.getParameter("description");
		Double askingPrice = Double.parseDouble(request.getParameter("askingPrice"));
		Vehicle vehicle = new Vehicle(images, condition, year, make, model, color, mileage, 
				drive, transmission, fuel, mpg, interior, description);
		Listing listing = new Listing(vehicle, askingPrice);
		
		ListingsDAO dao = new ListingsDAO();
		dao.addToListings(listing);
		
		// if no error, then forward to AdminGetInventoryController:
		//request.getRequestDispatcher("AdminGetInventoryController").forward(request, response);
		doGet(request, response);
	}

}
