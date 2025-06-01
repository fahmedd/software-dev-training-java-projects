package com.fdmgroup.verification;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroupVerification.Classroom;
import com.fdmgroupVerification.Trainee;
import com.fdmgroupVerification.Trainer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)

public class ClassroomTest {
	
	Classroom class1;
	ArrayList<Trainee> threeTrainees;
	ArrayList<Trainee> fiveTrainees;
	
	@BeforeEach
	public void test_testSetup() { 
	
	class1= new Classroom();
	class1.setTrainer(MockTrainer);
	
	fiveTrainees= new ArrayList<Trainee>();   /// remove reinstating in the begining- dont want to create a new variable
	fiveTrainees.add(MockTrainee); fiveTrainees.add(MockTrainee2); fiveTrainees.add(MockTrainee3); 
	fiveTrainees.add(MockTrainee4); fiveTrainees.add(MockTrainee5);
	
	threeTrainees= new ArrayList<Trainee>();
	threeTrainees.add(MockTrainee); 
	threeTrainees.add(MockTrainee2); 
	threeTrainees.add(MockTrainee3);
	
	}
	

	@Mock 
	Trainer MockTrainer;
	
	@Mock 
	Trainee MockTrainee;
	
	@Mock 
	Trainee MockTrainee2;
	
	@Mock 
	Trainee MockTrainee3;
	
	@Mock 
	Trainee MockTrainee4;
	
	@Mock 
	Trainee MockTrainee5;
	
	
	@Test // 2
	public void test_ToVerifyThatWhenStartLessonMethodIsCalled_ItCallsTheMockTrainerObjectsTeachMethod() {
		class1.setTrainees(threeTrainees);
		class1.startLesson();
		verify(MockTrainer, times(1)).teach();
	}
	
	@Test // 3
	public void test_ToVerifyThatWhenEndLessonMethodIsCalled_ItCallsTheMockTrainerObjectsPrepareLessonMethod() {
		
		class1.setTrainees(threeTrainees);
		class1.endLesson();
		verify(MockTrainer,times(1)).prepareLesson();		
		
	}
	
	
	@Test// 4
	public void test_ToVerifyThatWhenStartExamMethodIsCalled_ItCallsTheMockTrainerObjectsInvigilateMethod() {
		class1.setTrainees(threeTrainees);
		class1.startExam("You have 30 minutes");
		verify(MockTrainer).invigilateExam("You have 30 minutes");
	
	}
	
	@Test ///5
	public void test_thatVerifiesThatWhenClassroomsReviewAllTraineesCodeMethodIsCalled_ItCallsTheMockTrainersReviewTraineeCodeMethod3Times() {
		class1.setTrainees(threeTrainees);
		class1.reviewAllTraineeCode();
		verify(MockTrainer).reviewTraineeCode(MockTrainee);
		verify(MockTrainer).reviewTraineeCode(MockTrainee2);
		verify(MockTrainer).reviewTraineeCode(MockTrainee3);
		
		
	
	}
	
	@Test ///6
	public void test_thatVerifiesThatWhenClassroomsReviewAllTraineesCodeMethodIsCalled_ItCallsTheMockTrainersReviewTraineeCodeMethod5Times() {
		class1.setTrainees(fiveTrainees);
		class1.reviewAllTraineeCode();
		verify(MockTrainer,times(1)).reviewTraineeCode(MockTrainee);
		verify(MockTrainer,times(1)).reviewTraineeCode(MockTrainee2);
		verify(MockTrainer,times(1)).reviewTraineeCode(MockTrainee3);
		verify(MockTrainer,times(1)).reviewTraineeCode(MockTrainee4);
		verify(MockTrainer,times(1)).reviewTraineeCode(MockTrainee5);
		
	}
//	
	@Test ///7
	public void test_VerfiesThatWhenClassroomsStartLessonMethodIsCalled_ItCallsLearnMethodOnEach3MockTrainees() {

		class1.setTrainees(threeTrainees);
		class1.startLesson();
		verify(MockTrainee,times(1)).learn();
		verify(MockTrainee2,times(1)).learn();
		verify(MockTrainee3,times(1)).learn();
	}
	
		
	@Test ///7
	public void test_VerfiesThatWhenClassroomsStartLessonMethodIsCalled_ItCallsLearnMethodOnEach5MockTrainees() {

		class1.setTrainees(fiveTrainees);
		class1.startLesson();
		verify(MockTrainee,times(1)).learn();
		verify(MockTrainee2,times(1)).learn();
		verify(MockTrainee3,times(1)).learn();
		verify(MockTrainee4,times(1)).learn();
		verify(MockTrainee5,times(1)).learn();
	}
}