package com.bbc_database.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Fees;
import com.bbc_database.entities.Student;
import com.bbc_database.service.DisplayAllFeeDetails;

/**
 * Servlet implementation class DisplayAllFeesServlet
 */
@WebServlet("/DisplayAllFeesServlet")
public class DisplayAllFeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllFeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in servlet:");
		
		 DisplayAllFeeDetails feeManager=(DisplayAllFeeDetails)getServletContext().getAttribute("feeManager");
		 
		 List<Fees> feeList=new ArrayList<Fees>();
		 feeList=feeManager.getAllFeeDetails();
		 System.out.println("fee lsit:"+feeList);
		 request.setAttribute("feeList", feeList);
			
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("FeeTable.jsp");
			rd.forward(request, response);
	}

}
