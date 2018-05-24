package com.cg.tms.dao;

public interface TraineeDAO {
	 public void addTrainee(Trainee trainee);
	 public List<Trainee> getAll();
	 public void update(Trainee view);
	 public Trainee deleteTrainee(int id);
     public Trainee getById(int id);
}
