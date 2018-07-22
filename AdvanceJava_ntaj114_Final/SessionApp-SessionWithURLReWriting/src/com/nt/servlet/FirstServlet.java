package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null;
		int age=0;
		HttpSession ses=null;
	  //general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		addrs=req.getParameter("addrs");
		//Create HttpSession obj on the server for browser
		ses=req.getSession(true);
		//keep form1/req1 data in Session obj as session attributes
		ses.setAttribute("name",name);
		ses.setAttribute("age",age);
		ses.setAttribute("addrs",addrs);
		//set session's idle time out period
		ses.setMaxInactiveInterval(60);
		//General Form2 dynamically
		pw.println("<body bgcolor='cyan'>");
		pw.println("<h1 style='color:red'> Skill and Experience</h1>");
		pw.println("<form action='"+res.encodeURL("surl")+"' method='post'>");
		pw.println("<table border='1'>");
		pw.println("<tr><td> Experience::</td>");
		pw.println(" <td><input type='text' name='exp'></td></tr>");
		pw.println("<tr><td> SkillSet::</td>");
		pw.println("<td><select name='skill' >");
		pw.println("<option value='java'>Java Pkg </option>");
		pw.println("<option value='.net'>.Net Pkg </option>");
		pw.println("<option value='php'>PHP Pkg </option>");
		pw.println("</select></td></tr>");
		pw.println("<tr><td colspan='2'><input type='submit' value='continue'></td></tr>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("<br><B><i>Session Id:::"+ses.getId());
		pw.println("</body>");
		
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class

