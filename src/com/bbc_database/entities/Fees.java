package com.bbc_database.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Fees {
	private int feeId;
	private double membershipFee;
	private Date membershipFeeTime;
	private double productFee;
	private Date productFeeTime;
	private double testFee;
	private Date testFeetime;
	Student student;
	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	public double getMembershipFee() {
		return membershipFee;
	}
	public void setMembershipFee(double membershipFee) {
		this.membershipFee = membershipFee;
	}
	public Date getMembershipFeeTime() {
		return membershipFeeTime;
	}
	public void setMembershipFeeTime(Date membershipFeeTime) {
		this.membershipFeeTime = membershipFeeTime;
	}
	public double getProductFee() {
		return productFee;
	}
	public void setProductFee(double productFee) {
		this.productFee = productFee;
	}
	public Date getProductFeeTime() {
		return productFeeTime;
	}
	public void setProductFeeTime(Date productFeeTime) {
		this.productFeeTime = productFeeTime;
	}
	public double getTestFee() {
		return testFee;
	}
	public void setTestFee(double testFee) {
		this.testFee = testFee;
	}
	public Date getTestFeetime() {
		return testFeetime;
	}
	public void setTestFeetime(Date testFeetime) {
		this.testFeetime = testFeetime;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String toString() {
		return "fee id:"+this.getFeeId()+ "membership fee:"+this.getMembershipFee()+" membership fee time:"+this.getMembershipFeeTime()+
				"test fee:"+this.getTestFee()+"test fee time:"+this.getTestFeetime()+"product fee:"+this.getProductFee()+
				"product fee time:"+this.getProductFeeTime()+"student id:"+this.getStudent().getstudentId();
	}
	
	
	

}
