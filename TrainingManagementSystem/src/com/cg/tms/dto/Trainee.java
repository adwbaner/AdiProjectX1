package com.cg.tms.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String location;
	public Trainee(int traineeId, String traineeName, String traineeDomain, String location) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeDomain = traineeDomain;
		this.location = location;
	}
	public Trainee() {
		super();
	}
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
