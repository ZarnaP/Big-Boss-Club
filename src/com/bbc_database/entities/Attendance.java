package com.bbc_database.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Attendance {
	private int attendanceId;
	private Date attendanceDate;
	private String attendanceTime;
	ClassLevel classLevelId;
	ClassTime classTimeId;
	Student studentId;
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public ClassLevel getClassLevelId() {
		return classLevelId;
	}
	public void setClassLevelId(ClassLevel classLevelId) {
		this.classLevelId = classLevelId;
	}
	public ClassTime getClassTimeId() {
		return classTimeId;
	}
	public void setClassTimeId(ClassTime classTimeId) {
		this.classTimeId = classTimeId;
	}
	public Student getStudentId() {
		return studentId;
	}
	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}
	
	public String toString() {
		return "attendance id:"+this.getAttendanceId()+"attendance date:"+this.getAttendanceDate()+"attendance time:"+this.getAttendanceTime()+
				"class level id:"+this.getClassLevelId().getLevelType()+ 
				"class time:"+this.getClassTimeId().getClassTime()+
				"student id:"+this.getStudentId().getstudentId();
	}
	
	
}
