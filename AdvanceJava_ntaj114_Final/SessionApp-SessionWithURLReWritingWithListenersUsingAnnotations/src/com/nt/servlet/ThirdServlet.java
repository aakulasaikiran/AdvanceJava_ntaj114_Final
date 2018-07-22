package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/turl")
public class ThirdServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String city=null;
		int salary=0;
		HttpSession ses=null;
		String name=null,addrs=null,skill=null;
		int age=0,exp=0;
		PreparedStatement ps=null;
		Connection con=null;
		int result=0;
		//general settings
		res.setContentType("text/html");
		pw=res.getWriter();
		//read form3/request3 data
		city=req.getParameter("city");
		salary=Integer.parseInt(req.getParameter("sal"));
	    //get Access to Session object
		ses=req.getSession(false);
		//read form1/req1 and form2/req2 data from Session object(Session attributes)
		name=(String)ses.getAttribute("name");
		addrs=(String)ses.getAttribute("addrs");
		age=(Integer)ses.getAttribute("age");
		skill=(String)ses.getAttribute("skill");
		exp=(Integer)ses.getAttribute("exp");
		//write form1/req1, form2/req2 and form3/req3 data to table as record
		try{
		  //register jdbc driver
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //Establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
		  //create PreparedStatement object
		  ps=con.prepareStatement("INSERT INTO INFO VALUES(?,?,?,?,?,?,?)");
		  //set values to query params
		  ps.setString(1,name);
		  ps.setString(2,addrs);
		  ps.setInt(3,age);
		  ps.setString(4,skill);
		  ps.setInt(5,exp);
		  ps.setString(6,city);
		  ps.setInt(7,salary);
		  //execuate the Query
		  result=ps.executeUpdate();
		  //process the Result
		  if(result==0)
			  pw.println("<br><h1>Registration failed</h1>");
		  else
			  pw.println("<br><h1>Registration succeded</h1>");
		  pw.println("<br><B><i>Session Id:::"+ses.getId());
		  //invalidate the session
		  ses.invalidate();
		  //provide hyperlink
		  pw.println("<a href='personal.html'>home</a>");
		  //close stream
		  pw.close();
		}//try
		 catch(SQLException se){
			   se.printStackTrace();
		   }
		   catch(ClassNotFoundException cnf){
			   cnf.printStackTrace();
		   }
		   catch(Exception e){
			   e.printStackTrace();
		   }
		  finally{
          try{
            if(ps!=null)
          	  ps.close();
          }
          catch(Exception e){
          	e.printStackTrace();
          }
          try{
            if(con!=null)
          	 con.close();
          }
          catch(Exception e){
          	e.printStackTrace();
          }
	  }//finally
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
 }//class
