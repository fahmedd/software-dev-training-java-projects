package com.fdmgroup.module15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Calculatortests {
	
	@Test
	public void testformultiply() {
		CalculatorT calc= new CalculatorT();
		double result= calc.multiply(5.0, 5.0);
		assertEquals(25.0,result,0.01);
	}

}
		
