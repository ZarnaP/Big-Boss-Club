package com.bbc_database.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbc_database.entities.Rank;
import com.bbc_database.entities.Student;

public class RankDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
 
	 public RankDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword) {
		// TODO Auto-generated constructor stub
		 RankDaoImpl.driverName = driverName;
		 RankDaoImpl.databaseUrl = databaseUrl;
		 RankDaoImpl.databaseUsername = databaseUsername;
		 RankDaoImpl.databasePassword = databasePassword;
		 
		 
	}

	 public Rank insertNewRank(Rank rank) {
			
			ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    	try {
	    		System.out.println("in try:");
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	   		 con=DriverManager.getConnection(  
	   		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		 
	   		String getAllStudents="insert into rank(belt_colour,rank_number) values(?,?)";
			ps=con.prepareStatement(getAllStudents,Statement.RETURN_GENERATED_KEYS);
			/*ps.setInt(1,student.getstudentId());*/
			ps.setString(1, rank.getBeltColour());
			ps.setInt(2, rank.getRankNumber());
		
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			System.out.println("successfully inserted");
			
		
	    		
	    	}
			
	    	catch(Exception e) {
	    		System.out.println("exception in insert method:"+e);
	    	}
			
	    	return rank;
		}

	 
	 public List<Rank> getAllRanks(){
	    	System.out.println("in  get all ranks method:");
	  
	    	ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
			
	    	List<Rank> rankList=new ArrayList<Rank>();
	    	
	    	try {
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	    		 con=DriverManager.getConnection(  
	    		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	    		
	    	/*	con=StudentDaoImpl.getConnection();*/
	    		String getRanks="select * from rank";
	    		ps=con.prepareStatement(getRanks);
	    		rs=ps.executeQuery();
	    		System.out.println("in try:");
	    		while(rs.next()) {
	    			Rank rank=new Rank();
	    			rank.setBeltColour(rs.getString("belt_colour"));
	    			rank.setRankNumber(rs.getInt("rank_number"));
	    			
	    			rankList.add(rank);
	    			System.out.println("values in student obj:"+rank);
	    			
	    			
	    		}
	    		rs.close();
	    		con.close();
	    		
	    	
	    	}
	    	catch(Exception e) {
	    		System.out.println("exception:"+e);
	    	}
			return rankList;
		}
	 
	 public  List<Student> getStudentsByRank(String beltColour) {
		 
		 List<Student> studentList=new ArrayList<Student>();
		 List<Integer> studentIdList=new ArrayList<>();
		 
			ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
			
	  
	    	
	    	try {
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	    		 con=DriverManager.getConnection(  
	    		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	    		 int id=0;
	    		 String getRankId="select id from rank where belt_colour=?";
	    		 ps=con.prepareStatement( getRankId);
	    		 ps.setString(1,beltColour);
	    		 rs=ps.executeQuery();
	    		 while(rs.next()) {
	    			 id=rs.getInt("id");
	    			
	    			 
	    		 }
	    		 System.out.println("belt id:"+id);
	    		 
	    		 String getStudentByRankId="select student_id from awarded_ranks where rank_id=?";
	    		 ps=con.prepareStatement( getStudentByRankId);
	    		 ps.setInt(1,id);
	    		 rs=ps.executeQuery();
	    		 int studentId=0;
	    		 
	    		 
	    		 while(rs.next()) {
	    			 studentId=rs.getInt("student_id");
	    			 studentIdList.add( studentId);
	    			 System.out.println("id of students:"+studentIdList);
	    			 
	    		 }
	    		
	    		 for(int sid:studentIdList) {
	    			 String getStudentDetails="select * from student where id=?";
	    	    		ps=con.prepareStatement(getStudentDetails);
	    	    		ps.setInt(1, sid);
	    	    		rs=ps.executeQuery();
	    	    		System.out.println("in try:");
	    	    		while(rs.next()) {
	    	    			Student student=new Student();
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
	    	    			studentList.add(student);
	    	    			System.out.println("values in student obj:"+student);
	    	    			
	    			 
	    	    		}
	    		 }
	    		 
	    	
	    		 
	    	}
	    	
	    	catch(Exception e) {
	    		System.out.println("exception in getStudentByRank:"+e);
	    	}
		 
	    	 return studentList;
	 }
	

}
