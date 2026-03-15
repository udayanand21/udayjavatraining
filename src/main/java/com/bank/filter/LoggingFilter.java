
package com.bank.filter;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*;
import java.io.IOException; import org.apache.logging.log4j.*;
@WebFilter("/*")
public class LoggingFilter implements Filter{
  private static final Logger log = LogManager.getLogger(LoggingFilter.class);
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
    HttpServletRequest r=(HttpServletRequest)req;
    log.info("{} {}", r.getMethod(), r.getRequestURI());
    chain.doFilter(req,res);
  }
}
