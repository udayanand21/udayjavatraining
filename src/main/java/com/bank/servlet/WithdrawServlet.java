package com.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bank.dao.AccountDAO;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {
  protected void doPost(HttpServletRequest r, HttpServletResponse h)
      throws IOException {
    try {
      int accno = Integer.parseInt(r.getParameter("accno"));
      double amt = Double.parseDouble(r.getParameter("amount"));
      new AccountDAO().withdraw(accno, amt);
      h.sendRedirect("index.jsp");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}