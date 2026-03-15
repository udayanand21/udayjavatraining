package com.coforge.employeemanagment;

public class Employee extends Person {
	String id;
	int Salary;

	
	public Employee(String id, int salary,String name) {
		super(name);
		this.id = id;
		Salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [name=" + name+ " , id=" + id + ", Salary=" + Salary + "]";
	}
	
	

}
