package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   PrintWriter pw=null;
		   String user=null,pwd=null;
		   
		  //general settings
		   pw=res.getWriter();
		   res.setContentType("text/html");
		   //read form data
		   user=req.getParameter("uname");
		   pwd=req.getParameter("pwd");
		   //validate username and password.
		   if(user.equals("raja@gmail.com") && pwd.equals("rani")){
			   pw.println("<h1 style='text-align:center'>Valid Credentials </h1>");
		   }
		   else{
			   pw.println("<h1 style='text-align:center'>InValid Credentials </h1>");
		   }
		   pw.println("<br> Form data is ::::"+user+"...."+pwd);
		   //add hyperlink
		   pw.println("<br><a href='login.html'>home</a>");
		   //close strem
		   pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}//doPost(-,-)

}//class...
