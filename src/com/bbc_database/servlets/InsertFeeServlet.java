package com.bbc_database.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Fees;
import com.bbc_database.service.InsertFee;
import com.bbc_database.service.InsertStudent;

/**
 * Servlet implementation class InsertFeeServlet
 */
@WebServlet("/InsertFeeServlet")
public class InsertFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFeeServlet() {
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
		InsertFee insertFeemanager=( InsertFee)getServletContext().getAttribute("insertFeemanager");
		if(request.getParameter("submit")!=null) {
			
			int enrollemtnNo=Integer.parseInt(request.getParameter("enrollmentNo"));
			double testFee=Double.parseDouble(request.getParameter(("testFee")));
			double membershipFee=Double.parseDouble(request.getParameter(("membershipFeeAmount")));;
			double productFee=Double.parseDouble(request.getParameter(("productFee")));;
			String testFeeDate=request.getParameter("testFeeDate");
			String productFeeDate=request.getParameter("productFeeDate");
			String membershipFeeDate=request.getParameter("membershipFeeDate");
			
			
			
			Fees fee=new Fees();
			fee.setMembershipFee(membershipFee);
			fee.setTestFee(testFee);
			fee.setProductFee(productFee);
			fee.setMembershipFeeTime(Date.valueOf(testFeeDate));
			fee.setProductFeeTime(Date.valueOf(productFeeDate));
			fee.setTestFeetime(Date.valueOf(membershipFeeDate));
			
			
			
			fee=insertFeemanager.insertFee(fee, enrollemtnNo);
			
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	}

}
