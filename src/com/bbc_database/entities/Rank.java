package com.bbc_database.entities;

public class Rank {
	
	private int rankId;
	private String beltColour;
	private int rankNumber; 
	
	public int getRankId() {
		return rankId;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	public String getBeltColour() {
		return beltColour;
	}
	public void setBeltColour(String beltColour) {
		this.beltColour = beltColour;
	}
	public int getRankNumber() {
		return rankNumber;
	}
	public void setRankNumber(int rankNumber) {
		this.rankNumber = rankNumber;
	}
	
	public String toString() {
		return "rank id:"+this.getRankId()+"belt colour:"+this.getBeltColour()+"rank number:"+this.getRankNumber();
	}

}
