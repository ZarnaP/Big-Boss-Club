package com.bbc_database.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
	
	private int studentId;
	private String firstName;
	private String 	LastName;
	private String address;
	private Date dateOfBirth;
	private String email;
	private int enrollmentNo;
	private LocalDate joiningDate;
	private long mobileNo;
	private String province;
	private String zipcode;
	private String studentCity;
	
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getstudentId() {
		return studentId;
	}
	public void setstudentId(int studentId) {
		this.studentId= studentId;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEnrollmentNo() {
		return enrollmentNo;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setEnrollmentNo(int enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate date) {
		this.joiningDate = date;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String toString() {
		return "student id:"+this.getstudentId()+"\tfirst name:"+this.getFirstName()+"last name:"+this.getLastName()+"\taddress:"+this.getAddress()+
				"\tdate of birth:"+this.getDateOfBirth()+"\temail:"+this.getEmail()+"\tenrollment number:"+this.getEnrollmentNo()+
				"\tjoining date:"+this.getJoiningDate()+"\tmobile no:"+this.getMobileNo();
	}
	
	
	
	

}
