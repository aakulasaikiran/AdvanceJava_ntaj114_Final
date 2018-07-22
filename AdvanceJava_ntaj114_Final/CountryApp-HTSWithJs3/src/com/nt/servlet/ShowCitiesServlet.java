package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCitiesServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int country =0;
		String countryCities[][]={{"delhi","mumbai","hyderabad"},
				                                       {"newyork","washingtomDC","LosAngels"},
				                                       {"london","manchester","oval"},
				                                       {"sydney","melborne","canberra"}
                                                    };
		String cities[]=new String[3];
		//read form data
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		country=Integer.parseInt(req.getParameter("country"));
		//write request processing logic
         
		   for(int i=0;i<cities.length;++i){
			   cities[i]=countryCities[country][i];
		   }
		   pw.println("Cities are::"+Arrays.toString(cities));
		//add hyperlink
		   pw.println("<br><a href='form.html'>home</a>");
		   //close stream
		   pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
