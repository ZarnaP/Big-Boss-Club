package com.bbc_database.DAO;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.bbc_database.entities.Attendance;
import com.bbc_database.entities.AwardedRanks;
import com.bbc_database.entities.ClassLevel;
import com.bbc_database.entities.ClassTime;
import com.bbc_database.entities.Fees;
import com.bbc_database.entities.Parent;
import com.bbc_database.entities.Rank;
import com.bbc_database.entities.Student;
import com.bbc_database.service.DisplayAllStudents;
import com.bbc_database.service.InsertStudent;


public class Main {

	public static void main(String args[]) throws ParseException {
		
		String driver="";
		String url="";
		String user="";
		String password="";
		List<Student> studentList=new ArrayList<Student>();
		List<Integer> rankList=new ArrayList<Integer>();
		StudentDaoImpl studentdao =new StudentDaoImpl(driver,url,user,password);
		
		AdminDaoImpl admindao =new AdminDaoImpl(driver,url,user,password);
		
		FeesDaoImpl feedao =new FeesDaoImpl(driver,url,user,password);
		
		/*List<Fees> feeList=new ArrayList<Fees>();
		
		feeList=feedao.getAllFees();
		System.out.println(feeList);
		*/
		
		RankDaoImpl rankdao =new RankDaoImpl(driver,url,user,password);
		
		ClassDaoImpl classdao=new ClassDaoImpl(driver,url,user,password);
		
		AttendanceDaoImpl attendancedao=new AttendanceDaoImpl(driver,url,user,password);
		Attendance attendance=new Attendance();
		
		attendance=attendancedao.insertAttendance("learner",  101, attendance);
		System.out.println("in main:"+attendance);
		
		/*List<AwardedRanks> parentList=new ArrayList<AwardedRanks>();
		
		 AwardedRanksDaoImpl dao=new  AwardedRanksDaoImpl(driver,url,user,password);
		 AwardedRanks awardedRanks=new AwardedRanks();
		 parentList=dao.getStudentRankInfoS(100);
		 
		 System.out.println(parentList);*/
		 
		/* StudentDaoImpl sdao=new StudentDaoImpl(driver,url,user,password);
		 Student student=sdao.getStudent(100);
		 
		 System.out.println(student);*/
		 
		/* System.out.println("in main awarded:"+parentList);

		Attendance attend=new Attendance();
		
		ClassTime ob1=new ClassTime();*/
		
		
		
		/*List<Parent> parentList=new ArrayList<Parent>();
		
	*/
		/*List<Fees> feeList=new ArrayList<Fees>();
		
		feeList=feedao.getAllFees();
		System.out.println(feeList);*/
		
		
		/*
		
	
		*/
		
		/*Student student=new Student();
		student.setstudentId(1);
		
		attend.setStudentId(student);
		attend=attendancedao.insertAttendance(9,"2010-12-23","beginer", "2009-02-24 12:51:42.11",attend);
		System.out.println("in main:"+attend);
		
		*/
		
		
		
	
		
		/*studentList=rankdao.getStudentsByRank("black");
		System.out.println("rankmlist in main:"+studentList);*/
		
		/*String dateofBirth="2010-03-09";  //yyyy-mm-dd
		 LocalDate localDate = LocalDate.parse(dateofBirth);
		
		LocalDate todayDate=java.time.LocalDate.now();
		System.out.println("todays date:"+todayDate);
		
		long range=ChronoUnit.DAYS.between(localDate, todayDate);
		System.out.println(range/365);*/
		

		
	/*	String loginid="aaa";
		String pwd="1abc";
		
		boolean validate= admindao.authenticate(loginid, pwd);
		System.out.println("validate:"+validate);*/
		
		/*;
		
		studentList=student.getAllStudents();
		System.out.println("student list:"+studentList);
		*/
		
		/*DisplayAllStudents object=new DisplayAllStudents(studentdao);
		studentList=studentdao.getAllStudents();
		System.out.println("in service:"+studentList);
		*/
		
		
		/*classdao.addClassLevel("beginer");
		classdao.addClassLevel("intermediate");
		classdao.addClassLevel("semi-intermediate");
		classdao.addClassLevel("final");
		*/
		
		/*InsertStudent insertobj=new InsertStudent(studentdao);
		
		Student obj=new Student();
		obj.setstudentId(2);
		obj.setAddress("347 caron");
		String lastCrawlDate = "2014-01-28";
		obj.setDateOfBirth(Date.valueOf(lastCrawlDate));
		obj.setEmail("abc@gmail.com");
		obj.setEnrollmentNo(1232143);
		String joiningDate="2009-09-01";
		obj.setJoiningDate(Date.valueOf(joiningDate));
		obj.setMobileNo(1234345454);
		obj.setStudentName("rr shah");
		
		obj=insertobj.insertStudent(obj);
		System.out.println("in print obj:"+obj);*/
		
		
		
		
		
	}
}
