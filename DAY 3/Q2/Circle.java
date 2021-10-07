package com.example;

public class Circle implements Shape{

	public String area(int radius) {
 		double  circleArea=radius*radius*3.14;
		return "Area of the circle- "+circleArea;
	}

	
}