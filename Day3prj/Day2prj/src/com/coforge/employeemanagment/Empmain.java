package com.coforge.employeemanagment;

public class Empmain {
	public static void main(String args[]) {
		Person p= new Person("Uday");
		System.out.println(p);
        Employee e = new Employee("E101", 60000, "Uday");
        System.out.println(e);
        Manager m = new Manager("E101", 60000, "Uday","CSE");
        System.out.println(m);
		
	}
}
