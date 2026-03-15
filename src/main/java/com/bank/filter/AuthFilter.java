
package com.bank.filter;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*;
import java.io.IOException;
@WebFilter("/*")
public class AuthFilter implements Filter{
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
    HttpServletRequest r=(HttpServletRequest)req; HttpServletResponse h=(HttpServletResponse)res;
    String p=r.getRequestURI(); HttpSession s=r.getSession(false);
    if(p.endsWith("login.jsp")||p.endsWith("login")) chain.doFilter(req,res);
    else if(s!=null && s.getAttribute("user")!=null) chain.doFilter(req,res);
    else h.sendRedirect("login.jsp");
  }
}
