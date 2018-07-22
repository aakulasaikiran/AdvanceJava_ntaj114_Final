package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletContext sc=null;
		ServletConfig cg=null;
		RequestDispatcher rd1=null,rd2=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//include header content
		  rd1=req.getRequestDispatcher("/headurl");
		  rd1.include(req,res);
		//Access  Servletcontext objs
		sc=getServletContext();
		pw.println("<br> driver context param value:"+sc.getInitParameter("driver"));
		pw.println("<br> dbuser context param value:"+sc.getInitParameter("dbuser"));
		pw.println("<br> dbpwd context param value:"+sc.getInitParameter("dbpwd"));
		//Access  ServletConfig obj
		cg=getServletConfig();
		pw.println("<br> p1 init param value"+cg.getInitParameter("p1"));
		pw.println("<br> p1 context param value"+sc.getInitParameter("p1"));
		
		//Gathering misc info about current web application and its web comps using
		// ServletContext object
		pw.println("<br> Server info:::"+sc.getServerInfo());
		pw.println("<br> Servlet api version:::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br> Context path of web application:::"+sc.getContextPath());
		pw.println("<br> MIME type of input.html"+sc.getMimeType("/input.html"));
		pw.println("<br> Path of  input.html"+sc.getRealPath("/input.html"));
		pw.println("<br> path of web application in WebServer"+sc.getRealPath("/"));
		//write to log file
		sc.log("Sys Date"+new java.util.Date());
		
		//include header content
		  rd2=req.getRequestDispatcher("/footer.html");
		  rd2.include(req,res);
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
