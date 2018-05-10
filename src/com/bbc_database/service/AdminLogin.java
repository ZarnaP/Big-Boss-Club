package com.bbc_database.service;

import com.bbc_database.DAO.AdminDaoImpl;
import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Admin;

public class AdminLogin {

	AdminDaoImpl admindao;
	
	public AdminLogin(AdminDaoImpl admindao) {
		this.admindao=admindao;
	}
	
	public boolean loginAdmin(String userName,String userPassword) {
		
		boolean validate=admindao.authenticate(userName, userPassword);
		return validate;
		
	}
}
