package com.coforge.controller.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.coforge.models.Employee;
import com.coforge.utils.DbUtil;

public class EmployeeDao {

    public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
        String sql = "SELECT eid, ename, salary, email, mobile, doj, dob FROM employee";
        List<Employee> empList = new ArrayList<>();

        try (Connection con = DbUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Employee e = new Employee();
                e.setEid(rs.getLong("eid"));
                e.setEename(rs.getString("ename"));
                e.setSalary(rs.getDouble("salary"));
                e.setEmail(rs.getString("email"));
                e.setMobile(rs.getString("mobile"));

                Date doj = rs.getDate("doj");
                Date dob = rs.getDate("dob");
                e.setDoj(doj != null ? doj.toLocalDate() : null);
                e.setDob(dob != null ? dob.toLocalDate() : null);

                empList.add(e);
            }
        }
        return empList;
    }

    public Employee findById(long eid) throws SQLException, ClassNotFoundException {
        String sql = "SELECT eid, ename, salary, email, mobile, doj, dob FROM employee WHERE eid = ?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, eid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee();
                    e.setEid(rs.getLong("eid"));
                    e.setEename(rs.getString("ename"));
                    e.setSalary(rs.getDouble("salary"));
                    e.setEmail(rs.getString("email"));
                    e.setMobile(rs.getString("mobile"));

                    Date doj = rs.getDate("doj");
                    Date dob = rs.getDate("dob");
                    e.setDoj(doj != null ? doj.toLocalDate() : null);
                    e.setDob(dob != null ? dob.toLocalDate() : null);

                    return e;
                }
            }
        }
        return null;
    }

    public Employee addEmployee(Employee emp) throws SQLException, ClassNotFoundException {
        // Generate next eid by fetching max eid and adding 1
        long nextEid = getNextEid();
        emp.setEid(nextEid);
        
        String sql = "INSERT INTO employee (eid, ename, salary, email, mobile, doj, dob) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, emp.getEid());
            ps.setString(2, emp.getEename());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getMobile());
            ps.setDate(6, emp.getDoj() != null ? Date.valueOf(emp.getDoj()) : null);
            ps.setDate(7, emp.getDob() != null ? Date.valueOf(emp.getDob()) : null);

            int rows = ps.executeUpdate();
            return rows > 0 ? emp : null;
        }
    }

    private long getNextEid() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COALESCE(MAX(eid), 1000) AS max_eid FROM employee";
        try (Connection con = DbUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getLong("max_eid") + 1;
            }
            return 1001;
        }
    }

    public boolean updateEmployee(Employee emp) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET ename = ?, salary = ?, email = ?, mobile = ?, doj = ?, dob = ? WHERE eid = ?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getEename());
            ps.setDouble(2, emp.getSalary());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getMobile());
            ps.setDate(5, emp.getDoj() != null ? Date.valueOf(emp.getDoj()) : null);
            ps.setDate(6, emp.getDob() != null ? Date.valueOf(emp.getDob()) : null);
            ps.setLong(7, emp.getEid());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteEmployee(long eid) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employee WHERE eid = ?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, eid);
            return ps.executeUpdate() > 0;
        }
    }

    public List<Employee> searchByMobile(String mobile) throws SQLException, ClassNotFoundException {
        String sql = "SELECT eid, ename, salary, email, mobile, doj, dob FROM employee WHERE mobile = ?";
        List<Employee> empList = new ArrayList<>();

        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mobile);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employee e = new Employee();
                    e.setEid(rs.getLong("eid"));
                    e.setEename(rs.getString("ename"));
                    e.setSalary(rs.getDouble("salary"));
                    e.setEmail(rs.getString("email"));
                    e.setMobile(rs.getString("mobile"));

                    Date doj = rs.getDate("doj");
                    Date dob = rs.getDate("dob");
                    e.setDoj(doj != null ? doj.toLocalDate() : null);
                    e.setDob(dob != null ? dob.toLocalDate() : null);

                    empList.add(e);
                }
            }
        }
        return empList;
    }

    public List<Employee> searchByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT eid, ename, salary, email, mobile, doj, dob FROM employee WHERE ename LIKE ?";
        List<Employee> empList = new ArrayList<>();

        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employee e = new Employee();
                    e.setEid(rs.getLong("eid"));
                    e.setEename(rs.getString("ename"));
                    e.setSalary(rs.getDouble("salary"));
                    e.setEmail(rs.getString("email"));
                    e.setMobile(rs.getString("mobile"));

                    Date doj = rs.getDate("doj");
                    Date dob = rs.getDate("dob");
                    e.setDoj(doj != null ? doj.toLocalDate() : null);
                    e.setDob(dob != null ? dob.toLocalDate() : null);

                    empList.add(e);
                }
            }
        }
        return empList;
    }

    public Employee searchByNameSingle(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT eid, ename, salary, email, mobile, doj, dob FROM employee WHERE ename LIKE ? LIMIT 1";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee();
                    e.setEid(rs.getLong("eid"));
                    e.setEename(rs.getString("ename"));
                    e.setSalary(rs.getDouble("salary"));
                    e.setEmail(rs.getString("email"));
                    e.setMobile(rs.getString("mobile"));

                    Date doj = rs.getDate("doj");
                    Date dob = rs.getDate("dob");
                    e.setDoj(doj != null ? doj.toLocalDate() : null);
                    e.setDob(dob != null ? dob.toLocalDate() : null);

                    return e;
                }
            }
        }
        return null;
    }
}