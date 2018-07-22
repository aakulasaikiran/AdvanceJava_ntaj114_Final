package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestCountFilter implements Filter {
	int count;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	  count=0;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc=null;
		count++;
		//get Access to ServletContext object
		sc=req.getServletContext();
		//keep request count in Servletcontext attribute
		sc.setAttribute("reqCount",count);
		//delegate request
		System.out.println("RequestCountFilter:before doFilter(-,-)");
		chain.doFilter(req, res);
		System.out.println("RequestCountFilter:after doFilter(-,-)");

	}
	
	@Override
	public void destroy() {
	  count=0;
	}

}
