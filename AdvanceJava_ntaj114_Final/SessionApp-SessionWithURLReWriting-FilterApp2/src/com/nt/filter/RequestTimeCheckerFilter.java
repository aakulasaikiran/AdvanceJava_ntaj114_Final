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


@WebFilter("/*")
public class RequestTimeCheckerFilter implements Filter {



	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		PrintWriter pw=null;
		Calendar calendar=null;
		int hour=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//check the time 
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY); //24 hrs
		if(hour<9 || hour>17){
			pw.println("<h1 style='color:red'>Please given request in between 9am to 5pm</h1>");
			return;
		}
		else{
			chain.doFilter(req, res);
		}
		
		//close stream
		pw.close();
	}//doFilter(-,-)

}
