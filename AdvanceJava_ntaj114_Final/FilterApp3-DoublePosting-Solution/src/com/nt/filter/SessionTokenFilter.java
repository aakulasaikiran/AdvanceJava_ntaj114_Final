package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class SessionTokenFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String method=null;
		HttpSession ses=null;
		HttpServletRequest hreq=null;
		Random rad=null;
		int sToken=0;
		int cToken=0;
		RequestDispatcher rd=null;
		//typecasting
		hreq=((HttpServletRequest)req);
		//get request method
		method=((HttpServletRequest)req).getMethod();
		if(method.equalsIgnoreCase("GET")){
			ses=hreq.getSession(true);
			//add server side token (Session token)
			rad=new Random();
			sToken=rad.nextInt(5000);
			ses.setAttribute("sToken",sToken);
			//complete request flow
			chain.doFilter(req, res);
		}
		else{
			//read Client Token
			cToken=Integer.parseInt(req.getParameter("cToken"));
			//read Server Token
			ses=hreq.getSession(false);
			sToken=(Integer)ses.getAttribute("sToken");
			//compare both tokens
			if(cToken==sToken){
				//chanage  Server Token
				rad=new Random();
				sToken=rad.nextInt(5000);
				ses.setAttribute("sToken",sToken);
				//delegate request to Servlet comp
				chain.doFilter(req,res);
			}//if
			else{
			 rd=req.getRequestDispatcher("/dbl_post.jsp");
			 rd.forward(req,res);
			}
			
		}//else
		
	}//doFilter(-,-)
}//class
