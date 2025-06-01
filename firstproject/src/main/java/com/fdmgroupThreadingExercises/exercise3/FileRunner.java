package com.fdmgroupThreadingExercises.exercise3;

public class FileRunner {

	public static void main(String[] args) {
		
		AverageCalculator calculator= new AverageCalculator();
		FileReaderThread one = new FileReaderThread(calculator,"C:/Users/Fatim/OneDrive/Desktop/textfileone.txt" );
		one.run();

	}

}
