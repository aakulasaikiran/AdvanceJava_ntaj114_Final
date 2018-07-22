package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMarriageEligibilityServlet extends HttpServlet {

	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("CMEServlet::process(-,-)");
		PrintWriter pw = null;
		String name = null, tage = null;
		int age = 0;
		String gender = null;
		Enumeration<String> e = null, e1 = null;
		List<String> errsList = null;
		String csvstatus = null;
		System.out.println("Current request mode/method:" + req.getMethod());

		// general settings
		pw = res.getWriter();
		res.setContentType("text/html");
		// read form data
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		gender = req.getParameter("gender");
		// read vflag value to enable or disable Server side form validations
		csvstatus = req.getParameter("vflag");

		if (csvstatus.equalsIgnoreCase("no")) {
			// Server Side form validation logic (java code)
			errsList = new ArrayList();
			System.out.println("CMES:Serside form validations are taking place...");
			if (name == null || name.equals("") || name.length() == 0) {
				errsList.add("<h4 style='color:red'> Person name is required</h4>");
			}
			if (tage == null || tage.equals("") || tage.length() == 0) {
				errsList.add("<h4 style='color:red'> Person age is required</h4>");
			} else {
				try {
					age = Integer.parseInt(tage);
					if (age <= 0 || age >= 150) {
						errsList.add("<h4 style='color:red'> Person age must be in between 1 to 150</h4>");
					}
				} catch (NumberFormatException nfe) {
					errsList.add("<h4 style='color:red'> Person age must be numberic value</h4>");
				}
			}
			if (errsList.size() > 0) {
				for (String err : errsList) {
					pw.println(err);
				} // for
				return;
			} // if
		} // if
		else{
			age=Integer.parseInt(tage);
		}

		// write b.logic (request processing logic)
		System.out.println("CMES: start of b.logic/service logic");
		if (gender.equalsIgnoreCase("m")) {
			if (age < 21)
				pw.println("<h1 style='color:red;text-align:center'>Mr." + name
						+ " u r under aged person to handle a life patner</h1>");
			else
				pw.println("<h1 style='color:green;text-align:center'>Mr." + name
						+ " u r elgible person to handle a life patner..Still Think Once</h1>");
		} else {
			if (age < 18)
				pw.println("<h1 style='color:red;text-align:center'>Miss." + name
						+ " u r small girl do not get big Trap</h1>");
			else
				pw.println("<h1 style='color:black;text-align:center'>Miss." + name
						+ " u r strong enogh to co-up with Life patner</h1>");
		}
		// add hyperlink
		pw.println("<br><a href='input.html'>home</a>");

		pw.println("<br> All req param names and values <br> ");
		e = req.getParameterNames();
		while (e.hasMoreElements()) {
			String pname = e.nextElement();
			String value = req.getParameter(pname);
			pw.println("<br>" + pname + "...." + value);
		}
		pw.println("<br> All req header names and values <br> ");
		e1 = req.getHeaderNames();
		while (e1.hasMoreElements()) {
			String hname = e1.nextElement();
			String hvalue = req.getHeader(hname);
			pw.println("<br>" + hname + "...." + hvalue);
		}
		pw.println("<br> Gathering misc info from client generated request<br>");
		// using methods of ServletRequest(I)
		pw.println("<br>Protocol::" + req.getProtocol());
		pw.println("<br>Scheme::" + req.getScheme());
		pw.println("<br>Browser Port::" + req.getRemotePort());
		pw.println("<br> Browser Machine IP::" + req.getRemoteAddr());
		pw.println("<br> Browser Machine Host::" + req.getRemoteHost());
		pw.println("<br>Remote user::" + req.getRemoteUser());
		pw.println("<br>Server Port ::" + req.getServerPort());
		pw.println("<br>Server name::" + req.getServerName());
		pw.println("<br> req content length" + req.getContentLength());
		pw.println("<br> req content type" + req.getContentType());
		// using method of HttpServletRequest(I)
		pw.println("<br>req method/mode::" + req.getMethod());
		pw.println("<br>req QueryString::" + req.getQueryString());
		pw.println("<br>req Servlet Path(virtual path)" + req.getServletPath());
		pw.println("<br> req uri" + req.getRequestURI());
		pw.println("<br> req url" + req.getRequestURL());
		pw.println("<br> Context path" + req.getContextPath());
		pw.println("<br> req path info " + req.getPathInfo());
		pw.println("<h1> date and time::" + new Date());
		// close stream
		pw.close();
	}// doGet(-,-)

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("CMEServlet:doGet(-,-)");
		process(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("CMEServlet:doPost(-,-)");
		process(req, res);
	}

}// class
