package com.coforge.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Simple demo credentials - in production, use database
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        boolean isValid = validateCredentials(username, password, role);

        if (isValid) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            if ("admin".equals(role)) {
                resp.sendRedirect(req.getContextPath() + "/admin-dashboard");
            } else {
                resp.sendRedirect(req.getContextPath() + "/user-view");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Redirect to login page
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    private boolean validateCredentials(String username, String password, String role) {
        if ("admin".equals(role)) {
            return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
        } else if ("user".equals(role)) {
            return USER_USERNAME.equals(username) && USER_PASSWORD.equals(password);
        }
        return false;
    }
}
