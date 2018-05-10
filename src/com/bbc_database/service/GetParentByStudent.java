package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Parent;

public class GetParentByStudent {
	
StudentDaoImpl studentdao;
	
	public GetParentByStudent(StudentDaoImpl studentdao) {
		this.studentdao=studentdao;
	}
	
	public List<Parent> getParentByStudent(int enrollmentNo) {
		Parent parent=new Parent();
		List<Parent> parentList=new ArrayList<Parent>();
		parentList=studentdao.getParentDetailsByStudent(enrollmentNo);
		return parentList;
		
	}
	

}
