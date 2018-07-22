//VoterServlet.java
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class VoterServlet extends HttpServlet
{
	public  void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=null;
	     String name=null,tage=null;
		 int age=0;
		 //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data(req parameters)
		 name=req.getParameter("pname");
		 tage=req.getParameter("page");
		 age=Integer.parseInt(tage);
		 //write request processing logic
		 if(age<18)
			 pw.println("<h1 style='color:red'> Mr/Miss/Mrs."+name+" u  r  not elgible to vote </h1>");
		else
			 pw.println("<h1 style='color:green'> Mr/Miss/Mrs."+name+" u  r   elgible  to vote </h1>");
		//add graphical hyperlink
		pw.println("<br><a href='http://localhost:3030/VoterApp/input.html'><img src='james.png' width='100' height='200'/></a>");
		//close stream 
		pw.close();
	}//doGet(-,-)
}//class
