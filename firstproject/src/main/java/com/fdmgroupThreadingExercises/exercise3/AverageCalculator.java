package com.fdmgroupThreadingExercises.exercise3;

public class AverageCalculator {

	private long total;
	private long count;
	
	public long getTotal(long total) {
		return total;
		
	}
	
	public long count(long count) {
		return count;
	}
	
	public synchronized void addToTotal(int number) {
		total += number;
		count++;
	}
	
	public double calculateAverage() {
		double average=total/count;
		return average;
		
	}
	
}
