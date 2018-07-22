package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.vo.UserDetailsVO;

@WebServlet("/inboxurl")
public class InBoxServlet extends HttpServlet {
	
  @Override
  	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  HttpSession ses=null;
	  UserDetailsVO vo=null;
	  //general settings
	  pw=res.getWriter();
	  res.setContentType("text/html");
	  pw.println("<h1> InBOX Details </h1>");
	  
	  pw.println("<br> <a href='signouturl'>SignOut</a>");
	  
  	}//doGet(-,-)
  
  @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-,-)
}//class

