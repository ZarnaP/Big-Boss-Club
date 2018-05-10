package com.bbc_database.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bbc_database.entities.AwardedRanks;
import com.bbc_database.entities.Rank;
import com.bbc_database.entities.Student;

public class AwardedRanksDaoImpl {
	
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
 
	 public AwardedRanksDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword) {
		// TODO Auto-generated constructor stub
		 AwardedRanksDaoImpl.driverName = driverName;
		 AwardedRanksDaoImpl.databaseUrl = databaseUrl;
		 AwardedRanksDaoImpl.databaseUsername = databaseUsername;
		 AwardedRanksDaoImpl.databasePassword = databasePassword;
		 
		 
	}
	 
	 public List<AwardedRanks> getStudentRankInfoS(int enrollmentNo) {
			ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    	
	    	 List<AwardedRanks> list=new ArrayList<AwardedRanks>();
	    	
	    	try {
	    		System.out.println("in try:");
	    		
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
				
				
				
				List<Integer> rankIdList=new ArrayList<Integer>();
				 String awardedRank="select rank_id from awarded_ranks where student_id=?";
			   		ps=con.prepareStatement(awardedRank);
					 ps.setInt(1, sid);
					 int rankid=0;
					rs=ps.executeQuery();
		    		while(rs.next()) {
		    			
		    			rankid=rs.getInt("rank_id");
		    			rankIdList.add(rankid);
		    		}
		    		
		    		System.out.println(rankIdList);
		    		for(int rankId:rankIdList) {
		    			
		    			Rank rank=new Rank();
		    			
		    			rank.setRankId(rankId);
		    			
		    			Student student1=new Student();
		    			 String getStudent1="select * from student where id=?";
		    			 ps=con.prepareStatement(getStudent1);
		    		   		ps.setInt(1, sid);
		    				rs=ps.executeQuery();
		    			/*	int sid=0;*/
		    				while(rs.next()) {
		    					sid=rs.getInt("id");
		    					 
		    					 student1.setAddress(rs.getString("address"));
		    					 student1.setDateOfBirth(rs.getDate("date_of_birth"));
		    					 student1.setEmail(rs.getString("email"));
		    					 student1.setEnrollmentNo(rs.getInt("enrollment_no"));
		    					 student1.setJoiningDate(rs.getDate("joining_date").toLocalDate());
		    					 student1.setMobileNo(rs.getLong("mobile_no"));
		    					 student1.setFirstName(rs.getString("student_fname"));
		    					 student1.setLastName(rs.getString("student_lname"));
		    					 student1.setStudentCity(rs.getString("student_city"));
		    					 student1.setProvince(rs.getString("province"));
		    					 student1.setZipcode(rs.getString("zipcode"));
		    				}
		    				
		    			
		    			 String awardedRankId="select * from awarded_ranks where rank_id=? AND student_id=?";
						 ps=con.prepareStatement(awardedRankId);
						 ps.setInt(1, rankId);
						 ps.setInt(2, sid);
						rs=ps.executeQuery();
						
						
						
						
						
						
						while(rs.next()) {
							AwardedRanks awardedRanks=new AwardedRanks();
							awardedRanks.setAwardedRankDateTime(rs.getDate("awarded_rank_date_time"));
							awardedRanks.setRank(rank);
							awardedRanks.setStudent(student1);
							list.add(awardedRanks);
							
						}
						
						
						System.out.println("awarded ranks:"+list);
						
						/*list.add(awardedRanks);*/
		    			
		    		}
				
		    		
					
		 
	    	}
	    	catch(Exception e) {
	    		System.out.println("exception :"+e);
	    	}
	    	System.out.println("in list:"+list);
	    	return list;
	    	
		 
	 }

}
