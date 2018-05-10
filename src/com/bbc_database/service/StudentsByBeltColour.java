package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.RankDaoImpl;
import com.bbc_database.entities.Student;

public class StudentsByBeltColour {
	
  RankDaoImpl rankdao;
	
	public StudentsByBeltColour(RankDaoImpl rankdao) {
		this.rankdao=rankdao;
	}
	
	public List<Student> getStudentsByBeltColour(String beltColour){
		List<Student> studentList=new ArrayList<Student>();
		studentList=rankdao.getStudentsByRank(beltColour);
		return studentList;
	}
	

}
