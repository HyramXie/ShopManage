package com.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
       

    public LoginFilter() {
        super();
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(userIsLoggedIn(request)) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/userlogin.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
	private boolean userIsLoggedIn(ServletRequest request) {
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session == null || session.getAttribute("user") == null)	
			return false;
		else 
			return true;
	}

}
