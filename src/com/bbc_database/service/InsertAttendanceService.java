package com.bbc_database.service;

import com.bbc_database.DAO.AttendanceDaoImpl;
import com.bbc_database.DAO.FeesDaoImpl;
import com.bbc_database.entities.Attendance;

public class InsertAttendanceService {
	
	AttendanceDaoImpl attendancedao;
	
	
	public InsertAttendanceService(AttendanceDaoImpl attendancedao) {
		this.attendancedao=attendancedao;
		}
	
	public Attendance insertAttendance(String classlevel,int enrollmentNo,Attendance attendance) {
		attendance=attendancedao.insertAttendance(classlevel, enrollmentNo, attendance);
		return attendance;
	}

}
