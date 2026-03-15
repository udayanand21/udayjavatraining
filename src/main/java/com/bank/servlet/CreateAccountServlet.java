
package com.bank.servlet; import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*; import com.bank.*; import com.bank.model.*; import com.bank.dao.*;
@WebServlet("/create")
public class CreateAccountServlet extends HttpServlet{
  protected void doPost(HttpServletRequest r,HttpServletResponse h) throws IOException{
    try{ new AccountDAO().create(new Account(Integer.parseInt(r.getParameter("accno")),r.getParameter("name"),r.getParameter("type"),Double.parseDouble(r.getParameter("balance")))); h.sendRedirect("index.jsp"); }
    catch(Exception e){ throw new RuntimeException(e);} }
}
