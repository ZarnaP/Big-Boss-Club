package com.bbc_database.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Rank;
import com.bbc_database.entities.Student;
import com.bbc_database.service.DisplayAllStudents;
import com.bbc_database.service.GetAllRanks;

/**
 * Servlet implementation class GetAllRanksServlet
 */
@WebServlet("/GetAllRanksServlet")
public class GetAllRanksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllRanksServlet() {
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
		GetAllRanks getAllRanks=(GetAllRanks)getServletContext().getAttribute("getAllRanks");
		
		List<Rank> rankList=new ArrayList<Rank>();
		rankList=getAllRanks.getAllRank();
		System.out.println("rank lsit in servlet:"+rankList);
		request.setAttribute("rankList", rankList);
		
		javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("DisplayRanks.jsp");
		rd.forward(request, response);
	}

}
