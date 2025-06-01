package com.fdmgroupThreadingExercises;

public class ThreadManagerChild extends ThreadManager{

	
	@Override
	public void createThreads(int number) {
		for (int count=0; count< number; count++) {
			Thread thread= new Thread(new Runnable(){
				public void run() {
					System.out.println(Thread.currentThread().getName()+ " is running");
				}
			});
			threadList.add(thread);
			
		}
	}
	
	public void runThreads() {
		for(Thread eachThread: threadList) {
			eachThread.start();
		}
	}
	
}
