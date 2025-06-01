package com.fdmgroupmodule19;


import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestCar {

	@Mock
	private Wheel mockWheel; //2. make mock object
	
	
	@Test
	public void tesThatWhenWeDriveCarThatWheelSpins() {
	//	Wheel wheel= new Wheel(); //real wheel object- dont use in michito
		Car car= new Car();
		car.setWheel(mockWheel);//mockwheel
		car.drive(); //attach method onto real object
		verify(mockWheel,times(1)).spin();// times will check method was called 1 time to the wheel
		//verifying that the wheel- spin method was called once
		
		//create substitiue fake wheel to test-check that it spins
	}
	
	@Test
	public void testThatWhenCarExceleratesWeCallAccerlerateMethodOnTheCar_SpinsFasterMethodIsCalledOnTheWheel() {
		
		when(mockWheel.getWheelSize()).thenReturn(20); //- stubbing before step 3 to return preffered value
		//dont do mockWheel.setSize 
		
		Car car= new Car(); //1.
		car.setWheel(mockWheel);//3. attach mock to real object
		car.accelerate(); //4. call method on the real object
		//verify(mockWheel,times(2)).spinsFaster(); // verify that mockobject had method called on it
		verify(mockWheel,Mockito.atLeastOnce()).spinsFaster();
		//verify(mockWheel,Mockito.atLeast(2)).spinsFaster();
		
		System.out.println(mockWheel.getWheelSize());
	}
	
	@Test //3
	public void testThatWhenCarExceleratesWeCallAccerlerateMethodOnTheCar_SpinsFasterMethodIsCalledOnTheWheelAlternative() {

		Car car= new Car();
		car.setWheel(mockWheel);
		car.accelerate(); 
		verify(mockWheel,times(1)).spinsFaster(); 
		verify(mockWheel,times(1)).spinsFaster(1);
	}
		

}

