package com.cg.tms.service;

import com.cg.tms.dao.List;
import com.cg.tms.dao.Trainee;

public interface TraineeService {

	public void addTrainee(Trainee trainee);

	public List<Trainee> getAll();

	public void update(Trainee view);

	public Trainee deleteTrainee(int id);

	public Trainee getById(int id);
}
