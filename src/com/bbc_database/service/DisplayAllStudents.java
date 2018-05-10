package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Student;

public class DisplayAllStudents {
	
	StudentDaoImpl studentdao;
	
	public DisplayAllStudents(StudentDaoImpl studentdao) {
		this.studentdao=studentdao;
	}
	
	public List<Student> getAllStudents(){
		List<Student> studentList=new ArrayList<Student>();
		studentList=studentdao.getAllStudents();
		System.out.println("student list in service:"+studentList);
		return studentList;
		
	}
	
	
	

}
