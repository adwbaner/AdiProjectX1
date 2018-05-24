package com.home.pms.service;

import com.home.pms.dto.Patient;
import com.home.pms.exception.PatientManagementSystemException;

public interface IPatientService
{
	public int addPatient(Patient patient) throws PatientManagementSystemException;
	
	public Patient getPatient(int patientId) throws PatientManagementSystemException;
}
