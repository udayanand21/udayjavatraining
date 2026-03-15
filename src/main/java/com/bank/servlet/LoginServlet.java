
package com.bank.servlet; import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
  protected void doPost(HttpServletRequest r,HttpServletResponse h) throws IOException{
    if("admin".equals(r.getParameter("user")) && "admin".equals(r.getParameter("pass"))){
      r.getSession().setAttribute("user","admin"); h.sendRedirect("index.jsp");
    } else h.sendRedirect("login.jsp");
  }
}
