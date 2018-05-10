package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.AdminDaoImpl;
import com.bbc_database.DAO.AwardedRanksDaoImpl;
import com.bbc_database.DAO.FeesDaoImpl;
import com.bbc_database.entities.AwardedRanks;

public class AwardedRanktoStudent {
	

	public AwardedRanktoStudent( AwardedRanksDaoImpl awardeddao) {
		this.awardeddao=awardeddao;
	}
	
	
	 
	 
	 
	 AwardedRanksDaoImpl awardeddao;
		
		public List<AwardedRanks> getAwardedRanksByStudent(int enrollmentNo){
			 List<AwardedRanks> list=new ArrayList<AwardedRanks>();
			list=awardeddao.getStudentRankInfoS(enrollmentNo);
			return list;
		}

}
