package com.fdmgroupVerification;

import java.util.ArrayList;

public class Classroom {
	
	private Trainer trainer;
	private ArrayList<Trainee> trainees= new ArrayList<Trainee>();
	
	
	public void setTrainees(ArrayList<Trainee> trainees) {
		this.trainees= trainees;
	}

	public ArrayList<Trainee> getTrainees() {
		return trainees;
	}
	
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public Trainer getTrainer() {
		return trainer;
	}

	public void startLesson() {
		trainer.teach();
		for (Trainee eachTrainee: trainees) {
		eachTrainee.learn();
		}
	}

	public void endLesson() {
		trainer.prepareLesson();
		
	}
	
	public void startExam(String topic) {
		trainer.invigilateExam(topic);
	}
	
	public void reviewAllTraineeCode() {
		for (Trainee eachTrainee: trainees) {
		trainer.reviewTraineeCode(eachTrainee);
		}
		
	}




	




	
	
	
	
	
	
	

}
