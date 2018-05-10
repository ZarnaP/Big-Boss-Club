package com.bbc_database.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Rank;
import com.bbc_database.service.InsertFee;
import com.bbc_database.service.InsertRank;

/**
 * Servlet implementation class InsertRankServlet
 */
@WebServlet("/InsertRankServlet")
public class InsertRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InsertRank insertRank=( InsertRank)getServletContext().getAttribute("insertRank");
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if(request.getParameter("submit")!=null) {
			
			int rankNumber=Integer.parseInt(request.getParameter("rankNumber"));
			System.out.println("rank no:"+rankNumber);
			String beltColour=request.getParameter("beltColour");
			
			Rank rank=new Rank();
			rank.setBeltColour(beltColour);
			rank.setRankNumber(rankNumber);
			
			rank=insertRank.insertRank(rank);
			
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("GetAllRanksServlet");
			rd.forward(request, response);
			
			
			
		}
	}

}
