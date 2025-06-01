package com.fdmgroupThreadingExercises.exercise3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderThread extends Thread{
	
	private AverageCalculator averageCalculator;
	private String fileName;

	public FileReaderThread(AverageCalculator averageCalculator,String fileName) {
		this.averageCalculator= averageCalculator;
		this.fileName=fileName;
	}
	
	@Override
	public void run() {
		try {
			FileReader fileReader= new FileReader(fileName);// you would put variable in incase location changes
			
			BufferedReader bufferedReader= new BufferedReader(fileReader);
			
			
//			int numbers;
//			numbers= bufferedReader.readLine();
				
			
			
				System.out.println(bufferedReader.readLine());
			
			
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
