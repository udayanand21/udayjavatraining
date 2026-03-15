package com.coforge.prj2;

public class Circle implements Shape{
	private double r;
	
	public Circle() {
		super();
	}
	public Circle(double r) {
		super();
		this.r = r;
	}
	@Override
	public void area() {
		System.out.println(3.14*r*r);
		
	}
	
	@Override
	public void circumferance() {
		System.out.println(2*3.14*r);
		
	}
}
