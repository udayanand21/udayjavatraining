package com.coforge.employeemanagment;

public class Manager extends Employee{
	private String dept;

	public Manager(String id, int salary, String name, String dept) {
		super(id, salary, name);
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ",dept=" + dept + ", id=" + id + ", Salary=" + Salary + "]";
	}
	
	
	

}
