

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbc_database.entities.Parent;
import com.bbc_database.entities.Student;
import com.bbc_database.service.DisplayAllStudents;
import com.bbc_database.service.InsertStudent;

/**
 * Servlet implementation class InsertStudentServlet
 */
@WebServlet("/InsertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    InsertStudent insertStudentManager=( InsertStudent)getServletContext().getAttribute("insertStudentManager");
		if(request.getParameter("submit")!=null) {
			System.out.println("in if:");
			
			
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			int enrollmentNo=Integer.parseInt(request.getParameter("enrollmentNo"));
			Student student1=insertStudentManager.getStudent(enrollmentNo);
			int storedEnrollmentNo=student1.getEnrollmentNo();
			if(enrollmentNo==storedEnrollmentNo) {
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
			
    			 out.println("<script type=\"text/javascript\">");
    			   out.println("alert('student already exists');");
    			   out.println("location='forms-basic.jsp';");
    			   out.println("</script>");
    			   
    			   
				
			}
			else {
			String emailId=request.getParameter("emailId");
			String mailingAddress=request.getParameter("mailingAddress");
			String province=request.getParameter("province");
			String zipcode=request.getParameter("zipcode");
			String studentCity=request.getParameter("studentCity");
			
			String dateofBirth=request.getParameter("dateofBirth");
			long contactNo=Long.parseLong(request.getParameter("contactNo"));
			
			/*String fatherName=request.getParameter("fatherName");
			
			int fatherContactNo=Integer.parseInt(request.getParameter("fatherContactNo"));
			String motherName=request.getParameter("motherName");
			int motherContactNo=Integer.parseInt(request.getParameter("motherContactNo"));
			*/
			String beltColour=request.getParameter("beltColour");
			
			
			
			
		
			
			/*String dateofBirth="2010-03-09";  //yyyy-mm-dd
*/			
			
			HttpSession session;
			
			Student student=new Student();
			
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEnrollmentNo(enrollmentNo);
			student.setEmail(emailId);
			student.setAddress(mailingAddress);
			student.setProvince(province);
			student.setZipcode(zipcode);
			student.setDateOfBirth(Date.valueOf(dateofBirth));
			student.setMobileNo(contactNo);
			student.setStudentCity(studentCity);
			student.setJoiningDate(java.time.LocalDate.now());
			student=insertStudentManager.insertStudent(student);
			
			 LocalDate localDate = LocalDate.parse(dateofBirth);
				
				LocalDate todayDate=java.time.LocalDate.now();
				System.out.println("todays date:"+todayDate);
				
				long range=ChronoUnit.DAYS.between(localDate, todayDate);
				System.out.println(range/365);
				
				
				
            if((range/365)<18) {
            	System.out.println("in if for 18:");
            	 request.getSession(false).setAttribute("student", student);
            	javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("Parent.jsp");
    			rd.forward(request, response);
				
			}
            
            else {
            	
            	javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
    			rd.forward(request, response);
				
            	
            }
			
			/*Parent parent=new Parent();*/
		
			
			/*System.out.println("student in servlet:"+student);
			
			System.out.println("inserted:");*/
			
			
			}
			
			
			
		}
		
		else {
			System.out.println("in else:");
		}
		
	}

}
