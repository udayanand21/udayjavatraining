
package com.bank.servlet; import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*; import com.bank.dao.*;
@WebServlet("/view")
public class ViewServlet extends HttpServlet{
  protected void doGet(HttpServletRequest r,HttpServletResponse h) throws IOException, ServletException{
    try{ r.setAttribute("list", new AccountDAO().all()); r.getRequestDispatcher("view.jsp").forward(r,h);} catch(Exception e){ throw new RuntimeException(e);} }
}
