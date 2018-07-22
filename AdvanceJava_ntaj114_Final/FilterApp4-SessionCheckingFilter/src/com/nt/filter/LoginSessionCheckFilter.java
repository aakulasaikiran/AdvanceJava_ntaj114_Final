package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/inboxurl")
public class LoginSessionCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException,ServletException {
		 HttpSession ses=null;
		 RequestDispatcher rd=null;
		//get Access to Sesson
		 ses=((HttpServletRequest)req).getSession(false);
		 if(ses==null || ses.getAttribute("userDetails")==null){
			req.setAttribute("errMsg","Please Login to access InBox");
			rd=req.getRequestDispatcher("/login.jsp");
			rd.forward(req, res);
		 }
		 else{
			 chain.doFilter(req,res);
		 }//else
	}//doFilter
}//filter
