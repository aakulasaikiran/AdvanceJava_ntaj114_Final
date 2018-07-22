package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PerformanceTestFilter implements Filter {
      
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		long start=0,end=0;
		start=System.currentTimeMillis();
		System.out.println("PerfTest:before doFilter(-,-)");
		 //forward request to next filter or dest web comp
		chain.doFilter(req,res);
		System.out.println("PerfTest:after doFilter(-,-)");
		end=System.currentTimeMillis();
		
		System.out.println(((HttpServletRequest)req).getRequestURI()+" has taken"+(end-start)+" ms");
		//write to log file
		req.getServletContext().log(((HttpServletRequest)req).getRequestURI()+" has taken"+(end-start)+" ms");
	}
}
