package com.fdmgroupThreadingExercises;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager extends Thread {
	
	protected List<Thread> threadList= new ArrayList<>();;
	
	
	public void createThreads(int number) {
		for (int count=0; count< number; count++) {
			MyRunnable MyRunnable= new MyRunnable();
			Thread thread= new Thread(MyRunnable);
			threadList.add(thread);
		}
		
	}
	

	public void runThreads() {
		for(Thread eachThread: threadList) {
			eachThread.start();
		}
	}

}
