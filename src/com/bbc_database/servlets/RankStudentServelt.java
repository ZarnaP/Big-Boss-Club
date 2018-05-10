package com.bbc_database.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.AwardedRanks;
import com.bbc_database.entities.Parent;
import com.bbc_database.service.AwardedRanktoStudent;
import com.bbc_database.service.GetParentByStudent;

/**
 * Servlet implementation class RankStudentServelt
 */
@WebServlet("/RankStudentServelt")
public class RankStudentServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankStudentServelt() {
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
		AwardedRanktoStudent awardedManager=(AwardedRanktoStudent)getServletContext().getAttribute("awardedManager");
		if(request.getParameter("submit")!=null) {
			int enrollmentNo=Integer.parseInt(request.getParameter("enrollmentNo"));
			Parent parent=new Parent();
			
			List<AwardedRanks> list=new ArrayList<AwardedRanks>();
			
			list=awardedManager.getAwardedRanksByStudent(enrollmentNo);
			System.out.println(list);
			
			request.setAttribute("rank", list);
			
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("RankInfoDisplay.jsp");
			rd.forward(request, response);

	}

}
}
