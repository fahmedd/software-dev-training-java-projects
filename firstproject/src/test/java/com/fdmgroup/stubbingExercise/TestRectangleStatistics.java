package com.fdmgroup.stubbingExercise;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroupMockito.stubbing.Rectangle;
import com.fdmgroupMockito.stubbing.RectangleStatistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class TestRectangleStatistics {
	
	@Mock
	private Rectangle Mockrectangle1;

	@Test
	public void testCalculateAreaMethod_ReturnsTwenty_WhenRectangle_WithWidth4AndLength5PassedIn() {
		
		RectangleStatistics stat1= new RectangleStatistics();
		
		when(Mockrectangle1.getWidth()).thenReturn(4);
		when(Mockrectangle1.getLength()).thenReturn(5);
		
		int calculatingStat1= stat1.calculateArea(Mockrectangle1);
		assertEquals(20,calculatingStat1);
	}
		
		
	@Test
	public void testCalculateAreaMethod_ReturnsTwenty_WhenRectangle_WithWidth5AndLength7PassedIn() {
			
		RectangleStatistics stat1= new RectangleStatistics();
			
		when(Mockrectangle1.getWidth()).thenReturn(5);
		when(Mockrectangle1.getLength()).thenReturn(7);
			
		int calculatingStat1= stat1.calculateArea(Mockrectangle1);
		assertEquals(35,calculatingStat1);
		
	}
	
	@Test
	void test_calculateCircumference_returns22_whenRectangleWithWidth3AndLength8PassedIn() {
		RectangleStatistics stat1= new RectangleStatistics();
		
		when(Mockrectangle1.getWidth()).thenReturn(3);
		when(Mockrectangle1.getLength()).thenReturn(8);
			
		int calculatingStat1= stat1.calculateCircumference(Mockrectangle1);
		assertEquals(22,calculatingStat1);
	}

	@Test
	void test_calculateCircumference_returns60_whenRectangleWithWidth10AndLength20PassedIn() {
		RectangleStatistics stat1= new RectangleStatistics();
		
		when(Mockrectangle1.getWidth()).thenReturn(10);
		when(Mockrectangle1.getLength()).thenReturn(20);
			
		int calculatingStat1= stat1.calculateCircumference(Mockrectangle1);
		assertEquals(60,calculatingStat1);
	}

	
	
	
}
