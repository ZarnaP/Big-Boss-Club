package com.bbc_database.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bbc_database.DAO.AdminDaoImpl;
import com.bbc_database.DAO.AttendanceDaoImpl;
import com.bbc_database.DAO.AwardedRanksDaoImpl;
import com.bbc_database.DAO.FeesDaoImpl;
import com.bbc_database.DAO.RankDaoImpl;
import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Student;
import com.bbc_database.service.AdminLogin;
import com.bbc_database.service.AwardedRanktoStudent;
import com.bbc_database.service.DisplayAllFeeDetails;
import com.bbc_database.service.DisplayAllStudents;
import com.bbc_database.service.GetAllRanks;
import com.bbc_database.service.GetFeeByStudent;
import com.bbc_database.service.GetParentByStudent;
import com.bbc_database.service.InsertAttendanceService;
import com.bbc_database.service.InsertFee;
import com.bbc_database.service.InsertParent;
import com.bbc_database.service.InsertRank;
import com.bbc_database.service.InsertStudent;



/**
 * 
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context=event.getServletContext();
    	String driverName=context.getInitParameter("com.mysql.jdbc.Driver");
    	String databaseUrl=context.getInitParameter("jdbc:mysql://localhost:3306/bcc_database");
    	String databaseUser=context.getInitParameter("root");
    	String databasePassword=context.getInitParameter("root");
    
	System.out.println("in listener:");
    StudentDaoImpl studentdao=new StudentDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    AdminDaoImpl admindao=new AdminDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    FeesDaoImpl feedao=new FeesDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    RankDaoImpl rankdao=new RankDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    AwardedRanksDaoImpl awardeddao=new AwardedRanksDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    AttendanceDaoImpl attendancedao=new AttendanceDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    
    DisplayAllStudents studentmanager=new  DisplayAllStudents(studentdao);
    context.setAttribute("studentmanager", studentmanager);
    
    InsertStudent insertStudentManager=new InsertStudent(studentdao);
    context.setAttribute("insertStudentManager", insertStudentManager);
    
     AdminLogin adminManager=new AdminLogin(admindao);
     context.setAttribute("adminManager", adminManager);
     
     InsertParent parentmanager=new InsertParent(studentdao);
     context.setAttribute("parentmanager", parentmanager);
     
     InsertFee insertFeemanager=new InsertFee(feedao);
     context.setAttribute("insertFeemanager", insertFeemanager);
     
     GetAllRanks getAllRanks=new GetAllRanks(rankdao);
     context.setAttribute("getAllRanks", getAllRanks);
     
     InsertRank insertRank=new InsertRank(rankdao);
     context.setAttribute("insertRank", insertRank);
     
     GetParentByStudent parentstudent=new GetParentByStudent(studentdao);
     context.setAttribute("parentstudent", parentstudent);
     
     GetFeeByStudent feestudent=new GetFeeByStudent(feedao);
     context.setAttribute("feestudent", feestudent);
     
     DisplayAllFeeDetails feeManager=new DisplayAllFeeDetails(feedao);
     context.setAttribute("feeManager", feeManager);
     
     AwardedRanktoStudent awardedManager=new AwardedRanktoStudent(awardeddao);
     context.setAttribute("awardedManager", awardedManager);
     
     InsertAttendanceService attendanceManager=new InsertAttendanceService(attendancedao);
     context.setAttribute("attendanceManager", attendanceManager);
     
     
     
     
     
    
    }
    
    
    
}
