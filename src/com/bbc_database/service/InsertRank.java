package com.bbc_database.service;

import java.util.ArrayList;
import java.util.List;

import com.bbc_database.DAO.RankDaoImpl;
import com.bbc_database.entities.Rank;

public class InsertRank {
	
RankDaoImpl rankdao;
	
	public InsertRank(RankDaoImpl rankdao) {
		this.rankdao=rankdao;
	}
	
	
	public Rank insertRank(Rank rank) {
		rank=rankdao.insertNewRank(rank);
		return rank;
		
	}
}
