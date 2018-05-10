package com.bbc_database.service;

import com.bbc_database.DAO.AdminDaoImpl;
import com.bbc_database.DAO.ClassDaoImpl;
import com.bbc_database.entities.ClassLevel;
import com.bbc_database.entities.ClassTime;

public class AddClassDetails {
	
	ClassDaoImpl classdao;
	
	public AddClassDetails(ClassDaoImpl classdao) {
		this.classdao=classdao;
	}

	
	public ClassTime addClassLevelDetails(ClassTime classTime,String classLevel) {
		System.out.println("in service:");
		classdao.insertClassDetails(classTime, classLevel);
		return classTime;
		
	}
}
