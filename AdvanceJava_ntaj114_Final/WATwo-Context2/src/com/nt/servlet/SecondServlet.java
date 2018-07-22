package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int cube=0;
		int value=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		
		//read form data
		value=Integer.parseInt(req.getParameter("t1"));
		cube=value*value*value;
		//display details
		pw.println("<br> SecondServlet: Cube value::"+cube);
		//do not close stream
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
