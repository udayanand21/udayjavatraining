package com.coforge.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.coforge.controller.dao.EmployeeDao;
import com.coforge.models.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final EmployeeDao dao = new EmployeeDao();

    private boolean isAdminSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return false;
        }
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!isAdminSession(req, resp)) return;
        
        String action = req.getParameter("action");
        if (action == null || action.equals("list")) {
            list(req, resp);
        } else if ("edit".equals(action)) {
            editForm(req, resp);
        } else if ("delete".equals(action)) {
            delete(req, resp);
        } else if ("addForm".equals(action)) {
            req.getRequestDispatcher("/EmpForm.jsp").forward(req, resp);
        } else if ("searchByMobile".equals(action)) {
            searchByMobile(req, resp);
        } else if ("searchByName".equals(action)) {
            searchByName(req, resp);
        } else {
            list(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!isAdminSession(req, resp)) return;
        
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            add(req, resp);
        } else if ("update".equals(action)) {
            update(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/employee");
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Employee> employees = dao.getAllEmployees();
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("/Emplist.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void editForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long eid = Long.parseLong(req.getParameter("eid"));
            Employee emp = dao.findById(eid);
            req.setAttribute("emp", emp);
            req.getRequestDispatcher("/EmpForm.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Employee e = new Employee();
            // Don't set eid for add - DAO will generate it
            e.setEename(req.getParameter("ename"));
            e.setSalary(Double.parseDouble(req.getParameter("salary")));
            e.setEmail(req.getParameter("email"));
            e.setMobile(req.getParameter("mobile"));
            String dojStr = req.getParameter("doj");
            String dobStr = req.getParameter("dob");
            e.setDoj(dojStr == null || dojStr.isBlank() ? null : LocalDate.parse(dojStr));
            e.setDob(dobStr == null || dobStr.isBlank() ? null : LocalDate.parse(dobStr));
            
            dao.addEmployee(e);
            resp.sendRedirect(req.getContextPath() + "/employee");
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Employee e = parseEmployee(req);
            dao.updateEmployee(e);
            resp.sendRedirect(req.getContextPath() + "/employee");
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long eid = Long.parseLong(req.getParameter("eid"));
            dao.deleteEmployee(eid);
            resp.sendRedirect(req.getContextPath() + "/employee");
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private Employee parseEmployee(HttpServletRequest req) {
        Employee e = new Employee();
        String eidStr = req.getParameter("eid");
        if (eidStr != null && !eidStr.isBlank()) {
            e.setEid(Long.parseLong(eidStr));
        }
        e.setEename(req.getParameter("ename"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));
        e.setEmail(req.getParameter("email"));
        e.setMobile(req.getParameter("mobile"));
        String dojStr = req.getParameter("doj");
        String dobStr = req.getParameter("dob");
        e.setDoj(dojStr == null || dojStr.isBlank() ? null : LocalDate.parse(dojStr));
        e.setDob(dobStr == null || dobStr.isBlank() ? null : LocalDate.parse(dobStr));
        return e;
    }

    private void searchByMobile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String mobile = req.getParameter("mobile");
            if (mobile != null && !mobile.isBlank()) {
                List<Employee> employees = dao.searchByMobile(mobile);
                req.setAttribute("employees", employees);
                req.setAttribute("searchType", "mobile");
                req.setAttribute("searchValue", mobile);
            } else {
                req.setAttribute("searchError", "Please enter a mobile number");
                List<Employee> employees = dao.getAllEmployees();
                req.setAttribute("employees", employees);
            }
            req.getRequestDispatcher("/Emplist.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            if (name != null && !name.isBlank()) {
                List<Employee> employees = dao.searchByName(name);
                req.setAttribute("employees", employees);
                req.setAttribute("searchType", "name");
                req.setAttribute("searchValue", name);
            } else {
                req.setAttribute("searchError", "Please enter a name");
                List<Employee> employees = dao.getAllEmployees();
                req.setAttribute("employees", employees);
            }
            req.getRequestDispatcher("/Emplist.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}