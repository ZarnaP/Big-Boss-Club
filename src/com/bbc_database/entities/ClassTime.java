package com.bbc_database.entities;

import java.sql.Date;
import java.sql.Timestamp;

public class ClassTime {
	private int classTimeid;
	private String classDay;
	private String classTime;
	public int getClassTimeid() {
		return classTimeid;
	}
	public void setClassTimeid(int classTimeid) {
		this.classTimeid = classTimeid;
	}

	private Date classDate;
	
	public Date getClassDate() {
		return classDate;
	}
	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}

	ClassLevel classLevelId;
	
	public String getClassDay() {
		return classDay;
	}
	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String string) {
		this.classTime = string;
	}
	public ClassLevel getClassLevelId() {
		return classLevelId;
	}
	public void setClassLevelId(ClassLevel classLevelId) {
		this.classLevelId = classLevelId;
	}
	
	public String toString() {
		return "class day:"+this.getClassDay()+"class time:"+this.getClassTime()+"class level id:"+this.getClassLevelId().getClassLevelId();
	}
	
}
