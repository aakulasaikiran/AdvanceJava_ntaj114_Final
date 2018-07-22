package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  pw.println("<h1> date and time::"+new Date());
			 //res.setHeader("refresh","5");
			 //res.setIntHeader("refresh",5);
		  res.addHeader("content-disposition","inline;fileName='abc.html'");
			 //close stream
			 pw.close();
	}

}
