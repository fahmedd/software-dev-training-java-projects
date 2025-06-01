package com.fdmgroupMockito.stubbing;

public class RectangleStatistics {

	private int calculatedArea;
	private int calculatedCircumference;
	
	public int calculateArea(Rectangle rectangle) {
		return calculatedArea=rectangle.getLength()*rectangle.getWidth();
	}

	public int calculateCircumference(Rectangle rectangle) {
		return calculatedCircumference= 2*(rectangle.getLength()+ rectangle.getWidth());
	}

}
