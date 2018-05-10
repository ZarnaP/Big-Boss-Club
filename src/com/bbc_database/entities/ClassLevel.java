package com.bbc_database.entities;

public class ClassLevel {
	private int classLevelId;
	private String levelType;
	public int getClassLevelId() {
		return classLevelId;
	}
	public void setClassLevelId(int classLevelId) {
		this.classLevelId = classLevelId;
	}
	public String getLevelType() {
		return levelType;
	}
	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}
	
	public String toString() {
		return "class level id:"+this.getClassLevelId()+" level type:"+this.getLevelType();
	}
	
}
