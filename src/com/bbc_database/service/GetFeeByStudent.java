package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.FeesDaoImpl;
import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Fees;
import com.bbc_database.entities.Parent;

public class GetFeeByStudent {
	
FeesDaoImpl feedao;
	
	public GetFeeByStudent(FeesDaoImpl feedao) {
		this.feedao=feedao;
	}
	
	public List<Fees> getFeeDetailsByStudent(int enrollmentNo) {
		
		List<Fees> feeList=new ArrayList<Fees>();
		feeList=feedao.getFeeDetialsByStudent(enrollmentNo);
		return feeList;
		
	}

}
