package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class CheckBrowserFilter implements Filter {



	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		PrintWriter pw=null;
		String browser=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//check browser 
		browser=((HttpServletRequest)req).getHeader("user-agent");
		System.out.println(browser);
		if(browser.indexOf("Chrome")==-1){
			pw.println("<h1 style='color:red'>Please give request from google chrome</h1>");
			return;
		}
		else{
			chain.doFilter(req, res);
		}
		
		//close stream
		pw.close();
	}//doFilter(-,-)

}
