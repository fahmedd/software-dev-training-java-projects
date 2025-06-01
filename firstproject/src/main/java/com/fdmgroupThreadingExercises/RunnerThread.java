package com.fdmgroupThreadingExercises;

public class RunnerThread {

	public static void main(String[] args) {
		
		ThreadManager Manager1= new ThreadManager();
		Manager1.createThreads(5);
		Manager1.runThreads();
		
		ThreadManagerChild child1= new ThreadManagerChild();
		child1.createThreads(6);
		child1.runThreads();
	}

}
