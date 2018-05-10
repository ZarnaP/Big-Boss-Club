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
import com.bbc_database.service.GetFeeByStudent;

/**
 * Servlet implementation class FeeStudentServlet
 */
@WebServlet("/FeeStudentServlet")
public class FeeStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeeStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 GetFeeByStudent feestudent=(GetFeeByStudent)getServletContext().getAttribute("feestudent");
			if(request.getParameter("submit")!=null) {
				int enrollmentNo=Integer.parseInt(request.getParameter("enrollmentNo"));
				List<Fees> feeList=new ArrayList<Fees>();
				feeList=feestudent.getFeeDetailsByStudent(enrollmentNo);
				System.out.println(feeList);
				
				request.setAttribute("fee", feeList);
				
				javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("FeeInfoDsipaly.jsp");
				rd.forward(request, response);
		
	}


	}
}
