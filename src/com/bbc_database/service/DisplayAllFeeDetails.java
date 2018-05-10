package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.FeesDaoImpl;
import com.bbc_database.entities.Fees;

public class DisplayAllFeeDetails {
	
FeesDaoImpl feedao;
	
	public DisplayAllFeeDetails(FeesDaoImpl feedao) {
		this.feedao=feedao;
	}
	
	public List<Fees> getAllFeeDetails() {
		
		List<Fees> feeList=new ArrayList<Fees>();
		feeList=feedao.getAllFees();
		return feeList;
		
	}

}
