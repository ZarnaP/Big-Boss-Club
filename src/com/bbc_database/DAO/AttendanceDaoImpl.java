package com.bbc_database.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;

import com.bbc_database.entities.Attendance;
import com.bbc_database.entities.ClassLevel;
import com.bbc_database.entities.ClassTime;
import com.bbc_database.entities.Student;

public class AttendanceDaoImpl {
	
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
 
	 public AttendanceDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword) {
		// TODO Auto-generated constructor stub
		 AttendanceDaoImpl.driverName = driverName;
		 AttendanceDaoImpl.databaseUrl = databaseUrl;
		 AttendanceDaoImpl.databaseUsername = databaseUsername;
		 AttendanceDaoImpl.databasePassword = databasePassword;
	}
	 
	/* public List<Student> getAttendance(LocalDate startDate,LocalDate endDate){
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    	try {
	    		
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	   		    con=DriverManager.getConnection(  
	   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		    
	   		    String getAttendance="select * from attendance where "
	   		    
	   		    
	   		    
	    	}
	    	catch(Exception e) {
	    		System.out.println("exception:"+e);
	    	}
	 }*/
	 
	public Attendance insertAttendance(String classLevel,int enrollmentNo,Attendance attendance) {
		
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    
	    	try {
	    		
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	   		    con=DriverManager.getConnection(  
	   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		    
	   		 Student student=new Student();
			 String getStudent="select * from student where enrollment_no=?";
			 ps=con.prepareStatement(getStudent);
		   		ps.setInt(1, enrollmentNo);
				rs=ps.executeQuery();
				int sid=0;
				while(rs.next()) {
					sid=rs.getInt("id");
					 System.out.println(sid);
					 
					 student.setAddress(rs.getString("address"));
			 			student.setDateOfBirth(rs.getDate("date_of_birth"));
			 			student.setEmail(rs.getString("email"));
			 			student.setEnrollmentNo(rs.getInt("enrollment_no"));
			 			student.setJoiningDate(rs.getDate("joining_date").toLocalDate());
			 			student.setMobileNo(rs.getLong("mobile_no"));
			 			student.setFirstName(rs.getString("student_fname"));
			 			student.setLastName(rs.getString("student_lname"));
			 			student.setStudentCity(rs.getString("student_city"));
			 			student.setProvince(rs.getString("province"));
			 			student.setZipcode(rs.getString("zipcode"));
				}
				
				System.out.println("student:"+student);
				attendance.setStudentId(student);
				int studentID=student.getstudentId();
				
				 String getAllClassDetails="select * from class_level where level_type=?;";
				 ps=con.prepareStatement(getAllClassDetails);
			   	
			   		ps.setString(1, classLevel);
					rs=ps.executeQuery();
					ClassLevel level=new ClassLevel();
			   		while(rs.next()) {
			   			/*ClassTime classobj=new ClassTime();
			   			classobj.setClassDay(rs.getString("class_day"));
			   			classobj.setClassTime(rs.getTimestamp("class_time"));;
			   			int classLevelId=rs.getInt("class_level_id");*/
			   		
			   			level.setClassLevelId(rs.getInt("id"));
			   			level.setLevelType(rs.getString("level_type"));
			   			
			   			
			
			   		}
				
			   		System.out.println("level:"+level);
			   		attendance.setClassLevelId(level);
			   		
			   		
			   		
			   		String getAllClassTimeDetails="select * from class_time where class_time=?;";
					 ps=con.prepareStatement(getAllClassTimeDetails);
				   	
				   		ps.setString(1, "8:00 am");
						rs=ps.executeQuery();
						ClassTime classobj=new ClassTime();
				   		while(rs.next()) {
				   			
				   			classobj.setClassDay(rs.getString("class_day"));
				   			classobj.setClassTime(rs.getString("class_time"));
				   			classobj.setClassLevelId(level);
				   			
				   			
				   		}
				   		System.out.println("class obj:"+classobj);
				   		attendance.setClassTimeId(classobj);
				   		int classLevelId=level.getClassLevelId();
				   		int classtimeId=classobj.getClassTimeid();
				   	
			   		
				String insertAttendance="insert into attendance(class_level_id,class_time_id,student_id,attendance_date,attendance_time) values(?,?,?,?,?)";
				ps=con.prepareStatement(insertAttendance);
			
				ps.setInt(1,classLevelId);
				ps.setInt(2,1);
				ps.setInt(3,sid);
				ps.setDate(4,Date.valueOf(java.time.LocalDate.now()));
				ps.setString(5,"8:00 am");
				
				ps.executeUpdate();
	   		    
	   		    
	    	}
	    	catch(Exception e) {
	    		System.out.println("exception:"+e);
	    	}
		
		return attendance;
	}
	 
	
	 

}
