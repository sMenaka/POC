package lk.nie.planningDepOauthService.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
@WebFilter({"/*"})
public class CorsFilter implements Filter {
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      HttpServletResponse httpServletResponse = (HttpServletResponse)response;
      httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
      httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
      httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
      if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest)request).getMethod())) {
         httpServletResponse.setStatus(200);
      } else {
         chain.doFilter(request, response);
      }

   }

   public void destroy() {
   }

   public void init(FilterConfig config) throws ServletException {
   }
}
