package com.fdmgroupmodule19;

public class Car {

	private Wheel wheel;

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public void drive() {
		wheel.spin();// dependancy injection

	}

	public void accelerate() {
		wheel.spinsFaster();
		wheel.spinsFaster(1);// doesnt have to be same method name 
	}

}
