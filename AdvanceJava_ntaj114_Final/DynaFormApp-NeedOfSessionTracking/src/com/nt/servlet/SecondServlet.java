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
		String f2val1=null,f2val2=null;
		String name=null,fname=null,ms=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
	   //read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//read form1/req1 data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		ms=req.getParameter("ms");
		//Generate dynamic webpage having form1/req1 and form2/req2 data
		pw.println("<h1>Form1/req1 data</h1><br>");
		pw.println("<br> name:::"+name);
		pw.println("<br> father name::"+fname);
		pw.println("<br> Marital status::"+ms);
		pw.println("<h1>Form2/req2 data</h1><br>");
		pw.println("<br> form2 value1:: "+f2val1);
		pw.println("<br> form2 value2:: "+f2val2);
		//add hyperlink
		pw.println("<br><a href='details.html'>home</a>");
      	//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
