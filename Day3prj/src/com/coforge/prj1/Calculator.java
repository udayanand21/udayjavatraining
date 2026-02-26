package com.coforge.prj1;

public class Calculator implements CalcInterface,SciCalcInterface{

	public int add(int a, int b) {
		return a+b;
	}
	
	public int sub(int a, int b) {
		return a-b;
	}

	public int mul(int a, int b) {
		return a*b;
	}

	public void div(int a, int b) {
		System.out.println((float)a/b);
	}
	@Override
	public void power(double a, double b) {
		System.out.println(Math.pow(a, b));
	}
	@Override
	public void squareroot(double a) {
		System.out.println(Math.sqrt(a));
	}
	@Override
	public void logVal(double a) {
		System.out.println(Math.log10(a));
		
	}

	
}
