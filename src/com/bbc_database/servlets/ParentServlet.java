package com.bbc_database.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Parent;
import com.bbc_database.entities.Student;
import com.bbc_database.service.DisplayAllStudents;
import com.bbc_database.service.InsertParent;
import com.bbc_database.service.InsertStudent;

/**
 * Servlet implementation class ParentServlet
 */
@WebServlet("/ParentServlet")
public class ParentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParentServlet() {
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
		Student student=(Student)request.getSession(false).getAttribute("student");
		
		InsertParent parentmanager=(InsertParent)getServletContext().getAttribute("parentmanager");
		
		
		if(request.getParameter("submit")!=null) {
			
			int enrollmentNo=student.getEnrollmentNo();
			System.out.println("enroll:"+enrollmentNo);
			String fatherName=request.getParameter("fatherName");
			long fatherContactNo=Long.parseLong(request.getParameter("fatherContactNo"));
			String motherName=request.getParameter("motherName");
			long motherContactNo=Long.parseLong(request.getParameter("motherContactNo"));
			String parentEmail=request.getParameter("parentEmail");
			
			Parent parent=new Parent();
			parent.setFatherMobileNo(fatherContactNo);
			parent.setFatherName(fatherName);
			parent.setMotherMobileNo(motherContactNo);
			parent.setMotherName(motherName);
			parent.setEmailId(parentEmail);
			
			parent=parentmanager.insertParent(parent, enrollmentNo);
			
			
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} 
	}

}
