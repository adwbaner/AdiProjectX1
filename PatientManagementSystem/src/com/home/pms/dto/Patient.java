package com.home.pms.dto;

import java.util.Date;

public class Patient
{
	private int patientId;
	private String patientName;
	private int age;
	private String phone;
	private String description;
	private Date consultation_date;
	
	
	public Patient(int patientId, String patientName, int age, String phone, String description,
			Date consultation_date) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.phone = phone;
		this.description = description;
		this.consultation_date = consultation_date;
	}
	
	


	public Patient(String patientName, int age, String phone, String description, Date consultation_date) {
		super();
		this.patientName = patientName;
		this.age = age;
		this.phone = phone;
		this.description = description;
		this.consultation_date = consultation_date;
	}




	public Patient() {
		super();
	}


	




	public Patient(String patientName, int age, String phone, String description) {
		super();
		this.patientName = patientName;
		this.age = age;
		this.phone = phone;
		this.description = description;
	}




	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getConsultation_date() {
		return consultation_date;
	}


	public void setConsultation_date(Date consultation_date) {
		this.consultation_date = consultation_date;
	}




	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", phone=" + phone
				+ ", description=" + description + ", consultation_date=" + consultation_date + "]";
	}
	
	
	
	
	
		
	
	
	

}
