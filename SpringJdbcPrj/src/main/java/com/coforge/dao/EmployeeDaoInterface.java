package com.coforge.dao;

import java.util.List;

import com.coforge.entities.Employee;

public interface EmployeeDaoInterface {
	List<Employee> getAllEmployees();
	void insertEmployee(Employee employee);
	Employee getEmployeebyId(long eid);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
}
