package com.example;

public class Sphere implements Shape{

	public String area(int radius) {
		double sphereArea=4*3.14*(radius*radius);  
		return "Area of the sphere- "+sphereArea;
	}

	
}