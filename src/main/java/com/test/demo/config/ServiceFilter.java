package com.test.demo.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ServiceFilter
 */
@WebFilter(filterName="servicefilter",urlPatterns="/service/*")
public class ServiceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ServiceFilter() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;		
		HttpSession session  =req.getSession();
		
		if (session!=null) {//(session != null && session.getAttribute("user")!=null)||req.getServletPath().startsWith("/service/user/login")) {
			// pass the request along the filter chain			
			chain.doFilter(request, response);
		}
		else
		{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getOutputStream().print("{\"message\":\"no session\"}");
		
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Service filter init--------");
	}

}
