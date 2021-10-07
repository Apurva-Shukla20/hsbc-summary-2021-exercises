package com.example;
public class MainShape {

	public static void main(String[] args) {
		System.out.println("Circle instance");
		Circle c=new Circle();
		Area.getAllShape(c);
		System.out.println("Sphere instance");
		Sphere s=new Sphere();
		Area.getAllShape(s);
	}

}