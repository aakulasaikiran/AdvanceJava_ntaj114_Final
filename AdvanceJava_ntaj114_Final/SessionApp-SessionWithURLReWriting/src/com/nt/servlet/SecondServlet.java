package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String skill = null;
		int exp = 0;
		HttpSession ses = null;
		// General settings
		pw = res.getWriter();
		res.setContentType("text/html");
		// read form2/req2 data
		skill = req.getParameter("skill");
		exp = Integer.parseInt(req.getParameter("exp"));
		// Access HttpSession object
		ses = req.getSession(false);
		// keep form2/req2 data in Session obj as session attribute values
		ses.setAttribute("skill", skill);
		ses.setAttribute("exp", exp);
		// Generate Form3 Dyanmically
		pw.println("<body bgcolor='cyan'>");
		pw.println("<h1 style='color:red'> Expected Salary & Preffered Location</h1>");
		pw.println("<form action='"+res.encodeURL("turl")+"' method='post'>");
		pw.println("<table border='1'>");
		pw.println("<tr><td> Exprected Salary::</td>");
		pw.println(" <td><input type='text' name='sal'></td></tr>");
		pw.println("<tr><td> Preffered Location::</td>");
		pw.println("<td><input type='text' name='city'></td></tr>");
		pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("<br><B><i>Session Id:::"+ses.getId());
		pw.println("</body>");
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
