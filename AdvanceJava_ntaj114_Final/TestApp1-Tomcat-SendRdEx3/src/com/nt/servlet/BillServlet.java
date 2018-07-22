package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null;
		float price=0.0f;
		float qty=0.0f;
		float billAmt=0.0f;
		 //general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		 //read form data
		name=req.getParameter("iname");
		price=Float.parseFloat(req.getParameter("iprice"));
		qty=Float.parseFloat(req.getParameter("iqty"));
		//calculate bill Amount
		billAmt=price*qty;
		//Redirect the request based on the BillAmount
		if(billAmt>=50000){
			res.sendRedirect("http://localhost:7080/TestApp2-Weblogic-SendRdEx3/discounturl?iname="+name+"&bAmt="+billAmt);
		 }
		else{
		 pw.println("<h1 style='color:red'>Bill Details </h1>");
         pw.println("<br>Item name::"+name);			
         pw.println("<br>Item billAmount::"+billAmt);
         pw.println("<a href='form.html'>home</a>");
		}//else
		
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
