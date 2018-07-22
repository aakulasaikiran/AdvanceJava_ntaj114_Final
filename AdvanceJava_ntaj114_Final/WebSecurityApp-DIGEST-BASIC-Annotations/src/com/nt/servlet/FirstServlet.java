package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/furl")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="clerk"),
     httpMethodConstraints=@HttpMethodConstraint("GET")
                )
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		 //general settings
		  res.setContentType("text/html");
		  pw=res.getWriter();
		 //display messages
		  pw.println("<h1 style='color:red'>Welcome to Security </h1>");
		  pw.println("<br>Remote username ::"+req.getRemoteUser());
		  pw.println("<br> Authentication mode::"+req.getAuthType());
		  //close stream
		  pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class
