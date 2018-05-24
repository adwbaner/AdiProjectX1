package com.home.pms.dao;

import com.home.pms.dto.Patient;
import com.home.pms.exception.PatientManagementSystemException;

public interface IPatientDAO
{
	public int addPatient(Patient patient) throws PatientManagementSystemException;
	
	public Patient getPatient(int patientId) throws PatientManagementSystemException;
	
}
