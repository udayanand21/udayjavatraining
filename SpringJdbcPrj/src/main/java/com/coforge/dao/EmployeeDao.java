package com.coforge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Employee;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Repository
public class EmployeeDao implements EmployeeDaoInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {
		System.out.println("Employee Bean created, @post construct called");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Employee Bean destroyed, @PreDestroy called");
	}

	@Override
	public List<Employee> getAllEmployees() {
		String queryString = "select * from employee";
		RowMapper<Employee> rowMapper = (rs, rowNum) -> {
			Employee employee = new Employee();
			employee.setEid(rs.getLong("empid"));
			employee.setEname(rs.getString("ename"));
			employee.setSalary(rs.getDouble("salary"));
			return employee;
		};
		List<Employee> list = jdbcTemplate.query(queryString, rowMapper);
		return list;
	}

	@Override
	public void insertEmployee(Employee employee) {
		String queryString = "insert into employee(empid,ename,salary) values(?,?,?)";
		jdbcTemplate.update(queryString, employee.getEid(), employee.getEname(),
				employee.getSalary());
	}

	@Override
	public Employee getEmployeebyId(long eid) {
		String queryString = "select * from employee where empid=?";
		RowMapper<Employee> rowMapper = (rs, rowNum) -> {
			Employee employee = new Employee();
			employee.setEid(rs.getLong("empid"));
			employee.setEname(rs.getString("ename"));
			employee.setSalary(rs.getDouble("salary"));
			return employee;
		};
		List<Employee> list = jdbcTemplate.query(queryString, new Object[] { eid }, rowMapper);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void updateEmployee(Employee employee) {
		String queryString = "update employee set ename=?, salary=? where empid=?";
		jdbcTemplate.update(queryString, employee.getEname(), employee.getSalary(),
				employee.getEid());
	}

	@Override
	public void deleteEmployee(Employee employee) {
		String queryString = "delete from employee where empid=?";
		jdbcTemplate.update(queryString, employee.getEid());
	}
}