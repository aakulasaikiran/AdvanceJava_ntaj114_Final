package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   PrintWriter pw=null;
		   int value=0;
		   int square=0;
		   ServletContext sc1=null,sc2=null;
		   RequestDispatcher rd=null;
		  //general settings
		   pw=res.getWriter();
		   res.setContentType("text/html");
		  //read form data
		   value=Integer.parseInt(req.getParameter("t1"));
		   //calculuate square value
		   square=value*value;
		   pw.println("<b>FirstServlet::"+square);
		   //for Cross context communication
		   //get SerlvetContext obj of WAOne(current) web application
		   sc1=getServletContext();
		 //get SerlvetContext obj of WATwo(Dest) web application
		   sc2=sc1.getContext("/WATwo-Context2");
		   //create RequestDispatcher pointing to SecondServlet
		   rd=sc2.getRequestDispatcher("/secondurl");
		   rd.include(req,res);
		   //close stream
		   pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}
}//class
