package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookiesServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   PrintWriter pw=null;
		   Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		  //general settings
		   pw=res.getWriter();
		   res.setContentType("text/html");
		  //create cookies (In Memory Cookies)
		   ck1=new Cookie("ap","amaravathi");
		   ck2=new Cookie("ts","hyd");
		   res.addCookie(ck1);res.addCookie(ck2);
		 //create cookies (Persistent Cookies)
		   ck3=new Cookie("mh","mumbai");
		   ck4=new Cookie("mp","bhopal");
		   ck3.setMaxAge(60);
		   ck4.setMaxAge(60);
		   res.addCookie(ck3);res.addCookie(ck4);
		   pw.println("<b> Successful in setting cookies");
		   //close stream
		   pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}//class
