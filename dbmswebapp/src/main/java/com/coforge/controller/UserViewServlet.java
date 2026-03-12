package com.coforge.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.coforge.controller.dao.EmployeeDao;
import com.coforge.models.Employee;

@WebServlet("/user-view")
public class UserViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final EmployeeDao dao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        
        // Check if user is logged in and is user (not admin)
        if (session == null || !"user".equals(session.getAttribute("role"))) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        String action = req.getParameter("action");
        
        if ("searchByName".equals(action)) {
            searchByName(req, resp);
        } else {
            // Default: show search form
            req.getRequestDispatcher("/user-view.jsp").forward(req, resp);
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            if (name != null && !name.isBlank()) {
                Employee emp = dao.searchByNameSingle(name);
                if (emp != null) {
                    req.setAttribute("employee", emp);
                    req.setAttribute("found", true);
                } else {
                    req.setAttribute("found", false);
                    req.setAttribute("searchedName", name);
                }
            }
            req.getRequestDispatcher("/user-view.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
