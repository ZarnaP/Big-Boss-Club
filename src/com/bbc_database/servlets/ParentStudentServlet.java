package com.bbc_database.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Parent;
import com.bbc_database.service.DisplayAllStudents;
import com.bbc_database.service.GetParentByStudent;
import com.sun.xml.internal.bind.CycleRecoverable.Context;

/**
 * Servlet implementation class ParentStudentServlet
 */
@WebServlet("/ParentStudentServlet")
public class ParentStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParentStudentServlet() {
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
		
		GetParentByStudent parentstudent=(GetParentByStudent)getServletContext().getAttribute("parentstudent");
		if(request.getParameter("submit")!=null) {
			int enrollmentNo=Integer.parseInt(request.getParameter("enrollmentNo"));
			Parent parent=new Parent();
			List<Parent> parentList=new ArrayList<Parent>();
			parentList=parentstudent.getParentByStudent(enrollmentNo);
			System.out.println(parentList);
			
			request.setAttribute("parent", parentList);
			
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("ParentInfoDisplay.jsp");
			rd.forward(request, response);
			
			
		}
	}

}
