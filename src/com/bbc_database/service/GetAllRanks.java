package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.RankDaoImpl;
import com.bbc_database.DAO.StudentDaoImpl;
import com.bbc_database.entities.Rank;
import com.bbc_database.entities.Student;

public class GetAllRanks {
	
RankDaoImpl rankdao;
	
	public GetAllRanks(RankDaoImpl rankdao) {
		this.rankdao=rankdao;
	}
	
	public List<Rank> getAllRank(){
		List<Rank> rankList=new ArrayList<Rank>();
		rankList=rankdao.getAllRanks();
		System.out.println("student list in service:"+rankList);
		return rankList;
		
	}
	
	
	

}
