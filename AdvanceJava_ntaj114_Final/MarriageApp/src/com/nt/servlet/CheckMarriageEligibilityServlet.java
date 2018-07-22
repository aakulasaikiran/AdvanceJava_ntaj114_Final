package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMarriageEligibilityServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null;
		 int age=0;
		 String gender=null;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 name=req.getParameter("pname");
		 age=Integer.parseInt(req.getParameter("page"));
		 gender=req.getParameter("gender");
		 //write b.logic (request processing logic)
		 if(gender.equalsIgnoreCase("m")){
			 if(age<21)
				 pw.println("<h1 style='color:red;text-align:center'>Mr."+name+" u r under aged person to handle a life patner</h1>");
			 else
				 pw.println("<h1 style='color:green;text-align:center'>Mr."+name+" u r elgible person to handle a life patner..Still Think Once</h1>");
		 }
		 else{
			 if(age<18)
				 pw.println("<h1 style='color:red;text-align:center'>Miss."+name+" u r small girl do not get big Trap</h1>");
			 else
				 pw.println("<h1 style='color:black;text-align:center'>Miss."+name+" u r strong enogh to co-up with Life patner</h1>");
		 }
		  //add hyperlink
		 pw.println("<br><a href='http://localhost:3030/MarriageApp/input.html'>home</a>");
		 //close stream 
		 pw.close();
	}//doPost(-,-)
}//class
