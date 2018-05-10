package com.bbc_database.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bbc_database.entities.Admin;
import com.bbc_database.entities.Student;

public class AdminDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
 
	 public AdminDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword) {
		// TODO Auto-generated constructor stub
		 AdminDaoImpl.driverName = driverName;
		 AdminDaoImpl.databaseUrl = databaseUrl;
		 AdminDaoImpl.databaseUsername = databaseUsername;
		 AdminDaoImpl.databasePassword = databasePassword;
	}
	 
	 
	 public boolean authenticate(String loginid,String pwd) {
		 
		 ResultSet rs;
	    	Connection con = null;
	    	//Statement stmt = null;
	    	PreparedStatement ps = null;
			
	    	String storedName="";
	    	String storedPassword="";
	    	try {
	    		System.out.println("in try:");
	    		
	    		Class.forName("com.mysql.jdbc.Driver");  
	    		 con=DriverManager.getConnection(  
	    		"jdbc:mysql://localhost:3306/bcc_database","root","root"); 
	    		 
	    		 String getAdmin="select * from admin where admin_name=?";
	    		 
	    		 ps=con.prepareStatement(getAdmin);
	    		 ps.setString(1,loginid );
	     		 rs=ps.executeQuery();
	     		 
	     		while(rs.next()) {
	     			
	     			storedName=rs.getString("admin_name");
	     			System.out.println("stored name:"+storedName);
	     			storedPassword=rs.getString("admin_pwd");
	     			System.out.println("stored password:"+storedPassword);
	     			
	     		}
	     		/*admin.setAdminName(storedName);
	     		admin.setAdminPassword(storedName);
	     		*/
	     		rs.close();
	     		con.close();
	     		
		    		
	     	}
	    	catch(Exception e) {
	    		System.out.println("in admin method exception:"+e);
	    	}
	    	
	    	if(pwd.equals(storedPassword)) {
     			return true;
     		}
     		else {
     			return false;
     		}
  
		 
	 }

}
