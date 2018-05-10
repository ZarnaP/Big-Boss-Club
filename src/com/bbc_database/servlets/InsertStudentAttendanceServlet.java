package com.bbc_database.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc_database.entities.Attendance;
import com.bbc_database.service.InsertAttendanceService;
import com.bbc_database.service.InsertFee;

/**
 * Servlet implementation class InsertStudentAttendanceServlet
 */
@WebServlet("/InsertStudentAttendanceServlet")
public class InsertStudentAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudentAttendanceServlet() {
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
		
		InsertAttendanceService attendanceManager=( InsertAttendanceService)getServletContext().getAttribute("attendanceManager");
		if(request.getParameter("submit")!=null) {
			String classLevel=request.getParameter("classLevel");
			int enrollmentNo=Integer.parseInt(request.getParameter("enrollmentNo"));
			
			Attendance attendance=new Attendance();
			attendance=attendanceManager.insertAttendance(classLevel, enrollmentNo, attendance);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
		
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('attendance done');");
			   out.println("location='index.jsp';");
			   out.println("</script>");
			
			
		}
			
			
	}

}
