package com.bbc_database.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbc_database.entities.ClassLevel;
import com.bbc_database.entities.ClassTime;
import com.bbc_database.entities.Student;

public class ClassDaoImpl {

	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
 
	 public ClassDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword) {
		// TODO Auto-generated constructor stub
		 ClassDaoImpl.driverName = driverName;
		 ClassDaoImpl.databaseUrl = databaseUrl;
		 ClassDaoImpl.databaseUsername = databaseUsername;
		 ClassDaoImpl.databasePassword = databasePassword;
	}
	 
	 public ClassLevel addClassLevel(String classLevel) {
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    	ClassLevel level=new ClassLevel();
	    	try {
	    		System.out.println("in try:");
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	   		    con=DriverManager.getConnection(  
	   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		    
	   		 String insertClassLevel="insert into class_level(level_type) values(?)";
	 		ps=con.prepareStatement(insertClassLevel,Statement.RETURN_GENERATED_KEYS);
	 		/*ps.setInt(1,student.getstudentId());*/
	 		ps.setString(1, classLevel);
	 		ps.executeUpdate();
	 		rs=ps.getGeneratedKeys();
	 		System.out.println("successfully inserted");
	   		    
	    	}
	    	catch(Exception e) {
	    		System.out.println("exception:"+e);
	    	}
	    	
	    	return level;
	 }
	 
	 public ClassTime insertClassDetails(ClassTime classTime,String classLevel) {
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    	/*ClassTime classTime=new ClassTime();*/
	    	try {
	    		System.out.println("in try:");
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	   		    con=DriverManager.getConnection(  
	   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		    
	   		    String getClassLevelId="select id from class_level where level_type=?";
	   		    ps=con.prepareStatement(getClassLevelId);
	   		    ps.setString(1, classLevel);
	   		    rs=ps.executeQuery();
	   		    int classId=0;
	   		    while(rs.next()) {
	   		    	classId=rs.getInt("id");
	   		    	System.out.println("class level id:"+classId);
	   		    	
	   		    }
	   		   
	   		    ClassLevel  classlevel=new ClassLevel();
	   		    classlevel.setClassLevelId(classId);
	   		  classTime.setClassLevelId(classlevel);
	   		    
	   		    
	   		    
	   		 String insertClassDetails="insert into class_time(class_day,class_time,class_level_id,class_date) values(?,?,?,?)";
	   		ps=con.prepareStatement(insertClassDetails);
	   		ps.setString(1,classTime.getClassDay());
	   		ps.setString(2, classTime.getClassTime());
	   		ps.setInt(3, classId);
	   		ps.setDate(4, classTime.getClassDate());
	   		ps.executeUpdate();
	   		
	   		    
	   		    
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("exception:"+e);
	    	}
	    	
	    	return classTime;
	 }
	 
	 public List<ClassTime> getAllClassDetails(){
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    	/*ClassTime classTime=new ClassTime();*/
	    	List<ClassTime> classTimeList=new ArrayList<ClassTime>();
	    	try {
	    		System.out.println("in try:");
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	   		    con=DriverManager.getConnection(  
	   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		    
	   		 String getAllClassDetails="select * from class_time;";
	   		ps=con.prepareStatement(getAllClassDetails);
	   		rs=ps.executeQuery();
	   		while(rs.next()) {
	   			ClassTime classobj=new ClassTime();
	   			classobj.setClassDay(rs.getString("class_day"));
	   			classobj.setClassTime(rs.getString("class_time"));;
	   			int classLevelId=rs.getInt("class_level_id");
	   			ClassLevel level=new ClassLevel();
	   			level.setClassLevelId(classLevelId);
	   			classobj.setClassLevelId(level);
	   			classobj.setClassDate(rs.getDate("class_date"));
	   			classTimeList.add(classobj);
	   			
	   		}
	   		    
	   		    
	   		    
	   		    
	   		    
	    	}
	    	catch(Exception e) {
	    		System.out.println("exception in view all details:"+e);
	    	}
	    	
	    	return classTimeList;
		 
	 }
	 
	 public ClassTime getClassDetails(String classLevel) {
		 
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	        
	   		 ClassTime classTime=new ClassTime();
	    	try {
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	   		    con=DriverManager.getConnection(  
	   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		    
	   		    String getId="select id from class_level where level_type=?";
	   		    ps=con.prepareStatement(getId);
	   		    ps.setString(1, classLevel);
	   		    rs=ps.executeQuery();
	   		    int classId=0;
	   		    while(rs.next()) {
	   		    	classId=rs.getInt("id");
	   		    	System.out.println("class level id:"+classId);
	   		    	
	   		    }
	   		    
	   		  
	   		
	   		   
	   		  String getClass="select * from class_time where id=?";
	   		  ps=con.prepareStatement(getClass);
	   		    ps.setInt(1, classId);
	   		    rs=ps.executeQuery();
	   		    while(rs.next()) {
	   		    	
	   		    	classTime.setClassDate(rs.getDate("class_date"));
	   		    	classTime.setClassDay(rs.getString("class_day"));
	   		     ClassLevel classLevelobj=new ClassLevel();
	   		     classLevelobj.setClassLevelId(classId);
	   		    	classTime.setClassLevelId(classLevelobj);
	   		    	classTime.setClassTime(rs.getString("class_time"));
	   		    }
	   		  
	    		
	    	}
	    	catch(Exception e) {
	    		System.out.println("exception:"+e);
	    	}
		 
	    	 return classTime;
	 }
	 
	 public ClassLevel getClassLevel(String classLevel) {
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps=null;
	    	 ClassLevel classLevelobj=new  ClassLevel ();
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");  
	   		    con=DriverManager.getConnection(  
	   		    "jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	   		    
	   		  String getClass="select * from class_level where level_type=?";
	   		  ps=con.prepareStatement(getClass);
	   		    ps.setString(1, classLevel);
	   		    rs=ps.executeQuery();
	   		    while(rs.next()) {
	   		    	classLevelobj.setClassLevelId(rs.getInt("id"));
	   		    	classLevelobj.setLevelType(rs.getString("level_type"));
	   		    	
	   		    	
	   		    }
	   		    
	   		    
	        }  
	        catch(Exception e) {
	        	System.out.println("exception:"+e);
	        }
	      return classLevelobj;
	        	
	     }
}

	

