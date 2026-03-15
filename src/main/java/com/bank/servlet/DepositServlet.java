package com.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bank.dao.AccountDAO;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
  protected void doPost(HttpServletRequest r, HttpServletResponse h)
      throws IOException {
    try {
      int accno = Integer.parseInt(r.getParameter("accno"));
      double amt = Double.parseDouble(r.getParameter("amount"));
      new AccountDAO().deposit(accno, amt);
      h.sendRedirect("index.jsp");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
