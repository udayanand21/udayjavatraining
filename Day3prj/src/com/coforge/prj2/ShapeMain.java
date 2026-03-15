package com.coforge.prj2;
import java.util.Scanner;
public class ShapeMain {

	public static void main(String[] args) {
		Shape sh;
		String ShapeType;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter type of shape Circle/Square");
		ShapeType=sc.next();
		if(ShapeType.equals("Circle")) {
			System.out.println("Enter Radius");
			double r = sc.nextDouble();
			sh= new Circle(r);
			sh.area();
			sh.circumferance();
		}
		else {
			System.out.println("Enter Side");
			double side = sc.nextDouble();
			sh= new Square(side);
			sh.area();
			sh.circumferance();
			
		}
		
	
	}

}
