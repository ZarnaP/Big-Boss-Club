package com.bbc_database.entities;

import java.sql.Date;
import java.sql.Timestamp;

public class AwardedRanks {
	
	private Date awardedRankDateTime;
	Rank rank;
	Student student;
	public Date getAwardedRankDateTime() {
		return awardedRankDateTime;
	}
	public void setAwardedRankDateTime(Date awardedRankDateTime) {
		this.awardedRankDateTime = awardedRankDateTime;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String toString() {
		return "awarded rank time:"+this.getAwardedRankDateTime()+"rank id:"+this.getRank().getRankId()+
				"student id:"+this.getStudent().getstudentId();
	}
	

}
