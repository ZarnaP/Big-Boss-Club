package com.bbc_database.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bbc_database.entities.Parent;
import com.bbc_database.entities.Student;


public class StudentDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
 
	 public StudentDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword) {
		// TODO Auto-generated constructor stub
		 StudentDaoImpl.driverName = driverName;
	    	StudentDaoImpl.databaseUrl = databaseUrl;
	    	StudentDaoImpl.databaseUsername = databaseUsername;
	    	StudentDaoImpl.databasePassword = databasePassword;
	}


	/*public  static Connection getConnection() throws SQLException {
		
		 String url = "";
		 String username = "";
		 String password="";
		 try {
			 
			 
			 System.out.println("in connection method");
			 
			 Properties props = new Properties();
			    FileInputStream in = new FileInputStream("C:\\Users\\heli8\\eclipse-workspace\\bbc\\db.properties");
			    props.load(in);
			    in.close();

			    String driver = props.getProperty("jdbc.driver");
			    
			    System.out.println("driver:"+driver);
			    if (driver != null) {
			    	System.out.println("in if driver:");
			        Class.forName(driver) ;
			    }
			    
			    

			    url = props.getProperty("jdbc.url");
			    username = props.getProperty("jdbc.username");
			    password = props.getProperty("jdbc.password");
			    
			    System.out.println(url);
			    System.out.println(password);
			    System.out.println(username);
			
			    
		 }
		
		 catch(Exception e)
		 {
			 System.out.println("exception in static mehod :"+e);
		 }
		
		return DriverManager.getConnection(url, username, password);
			
		 
		 
	 }
	*/
	
	
	public List<Student> getAllStudents(){
		ResultSet rs;
    	Connection con = null;
    	//Statement stmt = null;
    	PreparedStatement ps=null;
    	 List<Student> studentList=new ArrayList<>();
    	try {
    		System.out.println("in try:");
    		
    		Class.forName("com.mysql.jdbc.Driver");  
   		    con=DriverManager.getConnection(  
   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
   		   
   		    String getAllStudents="select * from student";
   		 ps=con.prepareStatement(getAllStudents);
			rs=ps.executeQuery();
			while(rs.next()) {
				Student student=new Student();
				student.setStudentId(rs.getInt("id"));
				student.setAddress(rs.getString("address"));
				student.setDateOfBirth(rs.getDate("date_of_birth"));
				student.setEmail(rs.getString("email"));
				student.setEnrollmentNo(rs.getInt("enrollment_no"));
				student.setJoiningDate(java.time.LocalDate.now());
				student.setMobileNo(rs.getLong("mobile_no"));
				student.setFirstName(rs.getString("student_fname"));
				student.setLastName(rs.getString("student_lname"));
				student.setStudentCity(rs.getString("student_city"));
				student.setProvince(rs.getString("province"));
				student.setZipcode(rs.getString("zipcode"));
				studentList.add(student);
				
			}
    	}
    	catch(Exception e) {
    		System.out.println("exception:"+e);
    	}
    	return studentList;
	}
	
	public Student insertStudent(Student student) {
		
		ResultSet rs;
    	Connection con = null;
    	//Statement stmt = null;
    	PreparedStatement ps=null;
    	try {
    		System.out.println("in try:");
    		
    		Class.forName("com.mysql.jdbc.Driver");  
   		 con=DriverManager.getConnection(  
   		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
   		 
   		String getAllStudents="insert into student(address,date_of_birth,email,enrollment_no,joining_date,mobile_no,student_fname,student_lname,student_city,province,zipcode) values(?,?,?,?,?,?,?,?,?,?,?)";
		ps=con.prepareStatement(getAllStudents,Statement.RETURN_GENERATED_KEYS);
		/*ps.setInt(1,student.getstudentId());*/
		ps.setString(1, student.getAddress());
		ps.setDate(2, student.getDateOfBirth());
		ps.setString(3, student.getEmail());
		ps.setLong(4, student.getEnrollmentNo());
		ps.setDate(5,Date.valueOf(java.time.LocalDate.now()));
		ps.setLong(6, student.getMobileNo());
		ps.setString(7, student.getFirstName());
		ps.setString(8, student.getLastName());
		ps.setString(9,student.getStudentCity());
		ps.setString(10, student.getProvince());
		ps.setString(11,student.getZipcode());
		
		
		
		ps.executeUpdate();
		rs=ps.getGeneratedKeys();
		System.out.println("successfully inserted");
		
	
    		
    	}
		
    	catch(Exception e) {
    		System.out.println("exception in insert student method:"+e);
    	}
		
    	return student;
	}
	
public Parent insertParent(Parent parent,int enrollmentNo) {
		
		ResultSet rs;
    	Connection con = null;
    	//Statement stmt = null;
    	PreparedStatement ps=null;
    	try {
    		System.out.println("in try:");
    		
    		Class.forName("com.mysql.jdbc.Driver");  
   		 con=DriverManager.getConnection(  
   		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
   		 
   		 String getStudentId="select id from student where enrollment_no=?";
   		
   		ps=con.prepareStatement(getStudentId);
   		ps.setInt(1, enrollmentNo);
		rs=ps.executeQuery();
		int sid=0;
		while(rs.next()) {
			sid=rs.getInt("id");
		}
		
		Student student=new Student();
		student.setstudentId(sid);
		
		parent.setStudent(student);
		
		String getAllStudents="insert into parent(email_id,father_name,father_phone_no,mother_name,mother_phone_no,enrollment_no) values(?,?,?,?,?,?)";
	
   		ps=con.prepareStatement(getAllStudents,Statement.RETURN_GENERATED_KEYS);
   		ps.setString(1,parent.getEmailId());
   		ps.setString(2, parent.getFatherName());
   		ps.setLong(3, parent.getFatherMobileNo());
   		ps.setString(4, parent.getMotherName());
   		ps.setLong(5,parent.getMotherMobileNo());
   		ps.setInt(6, sid);
   		
		ps.executeUpdate();
	
    	}
		
    	catch(Exception e) {
    		System.out.println("exception in insert method:"+e);
    	}
		
    	return parent;
	}

public Student getStudent(int enrollmentNo) {

	ResultSet rs;
	Connection con = null;
	//Statement stmt = null;
	PreparedStatement ps=null;
	Student student=new Student();
	try {
		System.out.println("in try:");
		
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
		 
		 String getStudentId="select * from student where enrollment_no=?";
		 ps=con.prepareStatement(getStudentId,Statement.RETURN_GENERATED_KEYS);
		 ps.setInt(1,enrollmentNo );
		 rs=ps.executeQuery();
		 
		 while(rs.next()) {
 			
 			student.setstudentId(rs.getInt("id"));
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
 			
 			System.out.println("values in student obj:"+student);
 			
 			
 		}
 		rs.close();
 		con.close();
		 
	}
	catch(Exception e ) {
		System.out.println("getstudent:"+e);
	}
	return student;
	
}

public List<Parent> getParentDetailsByStudent(int enrollmentNo) {
	ResultSet rs;
	Connection con = null;
	//Statement stmt = null;
	PreparedStatement ps=null;
	Student student=new Student();
	List<Parent> parentList=new ArrayList<Parent>();
	 Parent parent=new Parent();
	try {
		
		System.out.println("in try:");
		
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
		 
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
			
			Student student1=new Student();
			student1.setStudentId(sid);
			
			parent.setStudent(student1);
			String getParent="select * from parent where enrollment_no=?";
			 
			 ps=con.prepareStatement(getParent,Statement.RETURN_GENERATED_KEYS);
			 ps.setInt(1,sid );
			 rs=ps.executeQuery();
			
			 while(rs.next()) {
				 parent.setFatherName(rs.getString("father_name"));
				 parent.setFatherMobileNo(rs.getLong("father_phone_no"));
				 parent.setMotherName(rs.getString("mother_name"));
				 parent.setMotherMobileNo(rs.getLong("mother_phone_no"));
				 parent.setEmailId(rs.getString("email_id"));
				 parentList.add(parent);
				 
			 }
		 
		
	}
	
	catch(Exception e) {
		System.out.println("exception:"+e);
	}
		 return parentList;
	
}
}
