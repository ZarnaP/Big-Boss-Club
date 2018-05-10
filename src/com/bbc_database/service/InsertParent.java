package com.bbc_database.service;

import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Parent;


public class InsertParent {
	
StudentDaoImpl studentdao;
	


	public InsertParent(StudentDaoImpl studentdao) {
	this.studentdao=studentdao;
	}
	
public Parent insertParent(Parent parent,int enrollmentNo) {
	
	parent=studentdao.insertParent(parent, enrollmentNo);
		
	System.out.println(parent);
		return parent;
	}
	
	

}
