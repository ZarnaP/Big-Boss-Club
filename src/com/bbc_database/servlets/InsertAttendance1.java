package com.bbc_database.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Student;
import com.bbc_database.service.DisplayAllStudents;

/**
 * Servlet implementation class InsertAttendance1
 */
@WebServlet("/InsertAttendance1")
public class InsertAttendance1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAttendance1() {
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
		System.out.println("in servlet:");
		
		DisplayAllStudents displayAllStudents=(DisplayAllStudents)getServletContext().getAttribute("studentmanager");
		List<Student> studentList=new ArrayList<Student>();
		studentList=displayAllStudents.getAllStudents();
		System.out.println("student lsit in servlet:"+studentList);
		request.setAttribute("studentList", studentList);
		
		javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("InsertAttendance.jsp");
		rd.forward(request, response);
		
	}

}
