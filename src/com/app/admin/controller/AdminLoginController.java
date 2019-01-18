package com.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.admin.model.Administrator;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		if (admin == null)
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		else
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		if (admin == null)
			admin = new Administrator();
		
		// already logged in:
		if (admin.isLoggedIn() == true) {
			session.setAttribute("username", admin.getUsername());
			request.getRequestDispatcher("adminAccount.jsp").forward(request, response);
		}
		
		// correct credentials:
		if (request.getParameter("username").equals(admin.getUsername()) && request.getParameter("password").equals(admin.getPassword())) {
			admin.setLoggedIn(true);
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("adminAccount.jsp").forward(request, response);
		}
		// incorrect credentials:
		else 
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	}

}
