package com.coforge.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.coforge.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee e = new Employee();
            e.setEid(rs.getLong("eid"));
            e.setEname(rs.getString("ename"));
            e.setSalary(rs.getDouble("salary"));
            return e;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT eid, ename, salary FROM employee", new EmployeeRowMapper());
    }

    @Override
    public void insertEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee (eid, ename, salary) VALUES (?, ?, ?)",
                employee.getEid(), employee.getEname(), employee.getSalary());
    }

    @Override
    public Employee getEmployeebyId(long eid) {
        try {
            return jdbcTemplate.queryForObject("SELECT eid, ename, salary FROM employee WHERE eid = ?",
                    new Object[] { eid }, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        jdbcTemplate.update("UPDATE employee SET ename = ?, salary = ? WHERE eid = ?",
                employee.getEname(), employee.getSalary(), employee.getEid());
    }

    @Override
    public void deleteEmployee(Employee employee) {
        jdbcTemplate.update("DELETE FROM employee WHERE eid = ?", employee.getEid());
    }
}
