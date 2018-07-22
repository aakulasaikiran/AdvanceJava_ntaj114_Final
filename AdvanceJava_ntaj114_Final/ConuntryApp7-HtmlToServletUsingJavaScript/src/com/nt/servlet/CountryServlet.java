package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String capitals[] = new String[] { "new Delhi", "islmabad", "kabool", "bejing" };
		String indiaStates[] = new String[] { "TS", "AP", "MP", "MH" };
		String pakistanStates[] = new String[] { "Punjab", "hyderabad", "karachi" };
		String afghanistanStates[] = new String[] { "kabool", "taliban", "kandhar" };
		String chinaStates[] = new String[] { "tippath", "zinping", "honkong" };
		PrintWriter pw = null;
		String country = null;
		// general settings
		pw = res.getWriter();
		res.setContentType("text/html");
		// read form data
		country = req.getParameter("country");
		// write request processing logic
		if (country.equalsIgnoreCase("india")) {
			pw.println("<br>Capitals:" + capitals[0]);
			pw.println("<br>States:" + Arrays.toString(indiaStates));
		} else if (country.equalsIgnoreCase("pak")) {
			pw.println("<br>Capitals:" + capitals[1]);
			pw.println("<br>States:" + Arrays.toString(pakistanStates));
		} else if (country.equalsIgnoreCase("afghani")) {
			pw.println("<br>Capitals:" + capitals[2]);
			pw.println("<br>States:" + Arrays.toString(afghanistanStates));
		} else {
			pw.println("<br>Capitals:" + capitals[3]);
			pw.println("<br>States:" + Arrays.toString(chinaStates));
		}
		// add hyperlinks
		pw.println("<a href='form.html'>home</a>");
		// close stream
		pw.close();
	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class
