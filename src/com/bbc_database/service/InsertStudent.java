package com.bbc_database.service;

import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Student;

public class InsertStudent {
	
StudentDaoImpl studentdao;
	


	public InsertStudent(StudentDaoImpl studentdao) {
	this.studentdao=studentdao;
	}
	
	public Student insertStudent(Student student) {
		
		student=studentdao.insertStudent(student);
		System.out.println("in service:"+student);
		return student;
	}
	
public Student getStudent(int enrollmentNo) {
		
		Student student=studentdao.getStudent(enrollmentNo);
		System.out.println("in service:"+student);
		return student;
	}
	
	

}
