package com.bbc_database.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbc_database.entities.Admin;
import com.bbc_database.service.AdminLogin;
import com.bbc_database.service.InsertStudent;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AdminLogin adminManager=(AdminLogin)getServletContext().getAttribute("adminManager");
		
		if(request.getParameter("submit")!=null) {
			String userName=request.getParameter("userName");
			String userPassword=request.getParameter("userPassword");
			
			boolean validate=adminManager.loginAdmin(userName, userPassword);
			if(validate==true) {
				 
				System.out.println("login successfull");
				
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
			else {
				System.out.println("failed");
				RequestDispatcher rd=request.getRequestDispatcher("Failure.jsp");
				rd.forward(request, response);
			}
			
			
			
		}
	}

}
