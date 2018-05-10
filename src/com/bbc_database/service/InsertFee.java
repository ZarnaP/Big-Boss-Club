package com.bbc_database.service;

import com.bbc_database.DAO.FeesDaoImpl;
import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Fees;

public class InsertFee {

	FeesDaoImpl feedao;
	
	
	public InsertFee(FeesDaoImpl feedao) {
		this.feedao=feedao;
		}
	
	public Fees insertFee(Fees fee,int enrollmentNo) {
		fee=feedao.insertFee(fee,enrollmentNo);
		return fee;
		
	}
}
