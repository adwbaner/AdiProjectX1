package com.home.pms.service;

import com.home.pms.dao.IPatientDAO;
import com.home.pms.dao.PatientDAOImpl;
import com.home.pms.dto.Patient;
import com.home.pms.exception.PatientManagementSystemException;

public class PatientServiceImpl implements IPatientService
{
	IPatientDAO patientDao=null;
	
	public PatientServiceImpl(){
		patientDao=new PatientDAOImpl();
	}
	
	@Override
	public int addPatient(Patient patient) throws PatientManagementSystemException {
		
		return patientDao.addPatient(patient);
	}

	@Override
	public Patient getPatient(int patientId) throws PatientManagementSystemException {
		
		return patientDao.getPatient(patientId);
	}

}
