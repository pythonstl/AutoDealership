package com.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.admin.model.Administrator;
import com.app.model.Transactions;
import com.app.repository.TransactionsDAO;

/**
 * Servlet implementation class AdminGetTransactionsController
 */
@WebServlet("/AdminGetTransactionsController")
public class AdminGetTransactionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetTransactionsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminGetTransactionsController.doGet()");
		HttpSession session = request.getSession();
		// YOU MAY NEED TO CAST ANOTHER SESSION ADMIN HERE, AS IN doPOST BELOW***************************************

		// Reads all lines in listings.txt:
		TransactionsDAO dao = new TransactionsDAO();
		Transactions transactions = new Transactions(dao.read());
		
		// Adds all listings to session:
		session.setAttribute("transactions", transactions);
		
		// Forwards to adminTransactions.jsp (to view all transactions):
		request.getRequestDispatcher("adminTransactions.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Location: AdminGetTransactionsController.doPost()");
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		
		// Checks if logged in:
		if (admin == null || admin.isLoggedIn() == false) 
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		else
			doGet(request, response);
	}

}
