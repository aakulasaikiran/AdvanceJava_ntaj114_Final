package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerurl")
public class RegisterServlet extends HttpServlet {
	private int count=0;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		pw.println("<br> name::"+req.getParameter("t1"));
		pw.println("<br> Father's name::"+req.getParameter("t2"));
		pw.println("<br> Address::"+req.getParameter("t3"));
		count++;
		pw.println("<br>Request count:::"+count);
		//add hyperlink
		pw.println("<a href='register.jsp'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
