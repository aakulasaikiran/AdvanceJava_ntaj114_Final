package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionDurationAnalyzerListener implements HttpSessionListener {
	private long start,end;
   @Override
   	public void sessionCreated(HttpSessionEvent se) {
	   
	   ServletContext sc=null;
	   start=System.currentTimeMillis();
	   //get Servletcontext object
	   sc=se.getSession().getServletContext();
	   sc.log("Session started at:::"+new Date());
   	}
   
   @Override
	public void sessionDestroyed(HttpSessionEvent se) {
	   ServletContext sc=null;
	   end=System.currentTimeMillis();
	   //get ServletContext object
	   sc=se.getSession().getServletContext();
	   sc.log("Session ended at:::"+new Date());
	   sc.log("Session duration::::"+(end-start)+"ms.");
	}

}//class
