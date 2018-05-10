package com.bbc_database.entities;

public class Parent {

	private int parentId;
	private String emailId;
	private String fatherName;
	private long fatherMobileNo;
	private String motherName;
	private long motherMobileNo;
	Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public long getFatherMobileNo() {
		return fatherMobileNo;
	}
	public void setFatherMobileNo(long fatherMobileNo) {
		this.fatherMobileNo = fatherMobileNo;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public long getMotherMobileNo() {
		return motherMobileNo;
	}
	public void setMotherMobileNo(long motherMobileNo) {
		this.motherMobileNo = motherMobileNo;
	}
	
	public String toString() {
		return "parent id:"+this.getParentId()+"email id:"+this.getEmailId()+"father name:"+this.getFatherName()+
				"father mobile no:"+this.getFatherMobileNo()+"mother name:"+this.getMotherName()+
				"mother mobile no:"+this.getMotherMobileNo()+"enrollment (student id):"+this.getStudent().getEnrollmentNo();
	}
	
}
