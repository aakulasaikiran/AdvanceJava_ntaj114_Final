package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,ms=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		ms=req.getParameter("ms");
		//Generate form2 dynamically based on marital status
		if(ms.equals("married")){
			pw.println("<form action='surl' method='post'>");
			pw.println("spouse name::: <input type='text' name='f2t1'><br>");
			pw.println("No.of children::: <input type='text' name='f2t2'><br>");
			//add form1 data to form2 as hidden box values
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}//if
		else{
			pw.println("<form action='surl' method='post'>");
			pw.println("When do u want to marry::: <input type='text' name='f2t1'><br>");
			pw.println("Why do u want to mary::: <input type='text' name='f2t2'><br>");
			//add form1 data to form2 as hidden box values
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class
