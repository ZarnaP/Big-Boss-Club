package com.bbc_database.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbc_database.entities.Fees;
import com.bbc_database.entities.Parent;
import com.bbc_database.entities.Student;

public class FeesDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
 
	 public FeesDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword) {
		// TODO Auto-generated constructor stub
		 FeesDaoImpl.driverName = driverName;
		 FeesDaoImpl.databaseUrl = databaseUrl;
		 FeesDaoImpl.databaseUsername = databaseUsername;
		 FeesDaoImpl.databasePassword = databasePassword;
		 
		 
	}
	 
	 public Fees insertFee(Fees fee,int enrollmentNo) {

		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps = null;
	    	
	    	try {
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	    		 con=DriverManager.getConnection(  
	    		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	    		 
	    		 String getStudent="select id from student where enrollment_no=?";
	    		 ps=con.prepareStatement(getStudent);
	    	   		ps.setInt(1, enrollmentNo);
	    			rs=ps.executeQuery();
	    			int sid=0;
	    			while(rs.next()) {
	    				sid=rs.getInt("id");
	    			}
	    		 
	    		
	    		 String insertFee="insert into fees(membership_fee,membership_fee_paytime,product_fee,product_fee_paytime,test_fee,test_fee_paytime,student_id) values(?,?,?,?,?,?,?)";
	    		 ps=con.prepareStatement(insertFee,Statement.RETURN_GENERATED_KEYS);
	    	  
	    		ps.setDouble(1, fee.getMembershipFee());
	    		ps.setDate(2, fee.getMembershipFeeTime());
	    		ps.setDouble(3, fee.getProductFee());
	    		ps.setDate(4, fee.getProductFeeTime());
	    		ps.setDouble(5, fee.getTestFee());
	    		ps.setDate(6, fee.getTestFeetime());
	    		ps.setInt(7, sid);
	    		 
	    		ps.executeUpdate();
	    		 
	    	}
			
	    	catch(Exception e) {
	    		System.out.println("exception in fee:"+e);
	    	}
	    	
	    	return fee;
		 
	 }
	 
	 public List<Fees> getFeeDetialsByStudent(int enrollmentNo){
		 
		 ResultSet rs;
			Connection con = null;
			//Statement stmt = null;
			PreparedStatement ps=null;
			Student student=new Student();
			List<Fees> feeList=new ArrayList<Fees>();
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
					student.setStudentId(sid);
					
					
					
					
					String getParent="select * from fees where student_id=?";
					 
					 ps=con.prepareStatement(getParent,Statement.RETURN_GENERATED_KEYS);
					 ps.setInt(1,sid );
					 rs=ps.executeQuery();
					
					 while(rs.next()) {
						 Fees fee=new Fees();
						 fee.setMembershipFee(rs.getDouble("membership_fee"));
						 fee.setMembershipFeeTime(rs.getDate("membership_fee_paytime"));
						 fee.setTestFee(rs.getDouble("test_fee"));
						 fee.setTestFeetime(rs.getDate("test_fee_paytime"));
						 fee.setProductFee(rs.getDouble("product_fee"));
						 fee.setProductFeeTime(rs.getDate("product_fee_paytime"));
						 fee.setStudent(student1);
						 feeList.add(fee);
						 
					 }
					
					
					
			}
			catch(Exception e) {
				System.out.println("exception :"+e);
			}
			
			return feeList;
		 
	 }
	 
	 public List<Fees> getAllFees(){
		 
		 
		 ResultSet rs;
			Connection con = null;
			//Statement stmt = null;
			PreparedStatement ps=null;
			Student student=new Student();
			List<Fees> feeList=new ArrayList<Fees>();
		
			try {
				
				System.out.println("in try:");
				
				Class.forName("com.mysql.jdbc.Driver");  
				 con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
				 
				 String getStudent="select id,enrollment_no from student";
				 List<Integer> studentIdList=new ArrayList<Integer>();
				 ps=con.prepareStatement(getStudent);
			   	
					rs=ps.executeQuery();
					int sid=0;
					int enrollmentNo=0;
					
					
					while(rs.next()) {
						sid=rs.getInt("id");
						enrollmentNo=rs.getInt("enrollment_no");
						 /*System.out.println(sid);*/
						 studentIdList.add(sid);
						
						 
						
					}
					System.out.println(studentIdList);
					student.setEnrollmentNo(enrollmentNo);
					student.setstudentId(sid);
					
					
					
					String getFees="select * from fees";
					 ps=con.prepareStatement(getFees,Statement.RETURN_GENERATED_KEYS);
					
					 rs=ps.executeQuery();
					

					 while(rs.next()) {
						 Fees fee=new Fees();
						 fee.setMembershipFee(rs.getDouble("membership_fee"));
						 fee.setMembershipFeeTime(rs.getDate("membership_fee_paytime"));
						 fee.setTestFee(rs.getDouble("test_fee"));
						 fee.setTestFeetime(rs.getDate("test_fee_paytime"));
						 fee.setProductFee(rs.getDouble("product_fee"));
						 fee.setProductFeeTime(rs.getDate("product_fee_paytime"));
						 fee.setStudent(student);
						 feeList.add(fee);
						
						 }

	
			}
			catch(Exception e) {
				System.out.println("exception :"+e);
			}
			
			return feeList;
		 
	 }
	 
	 

}
