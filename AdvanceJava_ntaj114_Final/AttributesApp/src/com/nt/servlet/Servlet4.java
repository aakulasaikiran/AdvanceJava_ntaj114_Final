package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet4 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read request attribute value
		pw.println("<br>(Servlet4)attr1(request) value:::"+req.getAttribute("attr1"));
		//read session attribute value
		ses=req.getSession();
		pw.println("<br>(Servlet4) attr2(session) value:::"+ses.getAttribute("attr2"));
		
		//read ServletContext attribute value
		sc=getServletContext();
		pw.println("<br>(Servlet4) attr3(sc) value:::"+sc.getAttribute("attr3"));
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
