package com.app.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.Customer;
import com.app.model.Listing;
import com.app.model.Transaction;
import com.app.repository.ListingsDAO;
import com.app.repository.TransactionsDAO;
import com.app.utility.Accounting.Calculate;
import com.app.utility.Accounting.Price;
import com.app.utility.DateManager;

/**
 * Servlet implementation class BuyController
 */
@WebServlet("/BuyController")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: BuyController.doGet()");
		HttpSession session = request.getSession();
		Listing listing = (Listing) session.getAttribute("listing");
		/*if (listing == null) {
			System.out.println("Session lost Listing object. Redirecting to GetInventoryController.");
			request.getRequestDispatcher("GetInventoryController").forward(request, response);
		}*/
		session.setAttribute("listing", listing);
		request.getRequestDispatcher("custBuy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: BuyController.doPost()");
		HttpSession session = request.getSession();
		Listing listing = (Listing) session.getAttribute("listing");
		listing.setDaysOnMarket(DateManager.getDaysBetween(listing.getListingDate(), LocalDate.now()));
		System.out.println(listing.getDaysOnMarket());
		
		// Gets minimum price of vehicle and compares it to customer's bid:
		double min = Price.getMinPriceOf(listing, listing.getDaysOnMarket()); 
		double bid = Double.parseDouble(request.getParameter("bid"));

		if (bid < min) {
			System.out.println("Bid is less than mininum price. Redirecting to custBuy.jsp.");
			request.getRequestDispatcher("custBuy.jsp").forward(request, response);
		}
		else {	
			// Adds transaction if bid >= minimum price:
			Transaction transaction = new Transaction(
					new Customer(request.getParameter("firstName"),
						request.getParameter("lastName"),
						request.getParameter("street"), 
						request.getParameter("city"),
						request.getParameter("state"),
						request.getParameter("zip"),
						request.getParameter("telephone"),
						request.getParameter("email")), 
					listing, bid);
			
			// Sets tax and total:
			transaction.setTax(Calculate.getTax(bid));
			transaction.setTotal(Calculate.getTotal(bid));
			
			// Saves transaction:
			TransactionsDAO dao = new TransactionsDAO();
			dao.addToTransactions(transaction);
			
			// Removes Listing from database:
			ListingsDAO ldao = new ListingsDAO();
			ldao.removeListing(transaction.getListing());
			
			// Forwards to a confirmation page:
			session.setAttribute("transaction", transaction);
			request.getRequestDispatcher("ConfirmationController").forward(request, response);
		}
	}

}
