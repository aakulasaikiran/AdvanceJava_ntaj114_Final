//DBServlet.java (approach1)
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*; //for jdbc api

public class DBServlet extends HttpServlet
{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public void init(){
		try{
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
             //create PrpearedStatement object
			 ps=con.prepareStatement("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?");
		   }//try
		   catch(SQLException se){
             se.printStackTrace();
		   }
		   catch(Exception e){
               e.printStackTrace();
		   }
		}//init()

		public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
               PrintWriter pw=null;
			   int no=0;
			  //general settings
			  pw=res.getWriter();
			  res.setContentType("text/html");
			  //read form data
               no=Integer.parseInt(req.getParameter("empno"));
			   //execute jdbc code
			   try{
				 //set empno to Select Query param value(?)
				 ps.setInt(1,no);
				 //execute the SQL Query
                  rs=ps.executeQuery();
				  //process the ResultSet
				  if(rs.next()){
                    pw.println("<h1>"+no+" Emp Details are::</h1><br>");
					pw.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
				  }//if
				  else{
                      pw.println("<h1> No Records found </h1>");
 			     }
			   }//try
			   catch(SQLException se){
				   se.printStackTrace();
			   }
			   catch(Exception e){
				   e.printStackTrace();
			   }
				 //add hyperlink
 			  pw.println("<br><br><br><a href='input.html'>home</a>");
				  //close stream
				  pw.close();
			   }//doGet(-,-)

			   	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
					  doGet(req,res);
				}//doPost(-,-)

				public void destroy(){
                   //close jdbc objs
				   try{
					  if(rs!=null)
						  rs.close();
				   }//try
				   catch(SQLException se){
					   se.printStackTrace();
				   }
				   try{
					  if(ps!=null)
						  ps.close();
				   }//try
				   catch(SQLException se){
					   se.printStackTrace();
				   }
   				   try{
					  if(con!=null)
						  con.close();
				   }//try
				   catch(SQLException se){
					   se.printStackTrace();
				   }
				}//destroy()
        }//class

