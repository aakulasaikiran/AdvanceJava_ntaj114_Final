package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiscountServlet extends HttpServlet {
  
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null;
		float billAmt=0.0f;
		float discount=0.0f;
		  //general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read addtionl req params given by BillServlet
		name=req.getParameter("iname");
		billAmt=Float.parseFloat(req.getParameter("bAmt"));
		//calcuate 30% discount amount
		discount=billAmt*0.3f;
		//display all the details
		pw.println("<h1 style='color:red'> Bill Details with discount</h1>");
		pw.println("<br> Item name:"+name);
		pw.println("<br>  Bill Amount:"+billAmt);
		pw.println("<br> Disocunt:"+discount);
		pw.println("<br> Final Amount:"+(billAmt-discount));
		pw.println("<a href='http://localhost:2525/TestApp1-Tomcat-SendRdEx3/form.html'>home</a>");
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
	

}
