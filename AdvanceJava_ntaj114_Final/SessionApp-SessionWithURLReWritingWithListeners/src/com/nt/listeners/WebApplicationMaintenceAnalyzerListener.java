package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebApplicationMaintenceAnalyzerListener implements ServletContextListener {
   private long start,end;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc=null;
	   start=System.currentTimeMillis();
	   //get ServletContext
	   sc=sce.getServletContext();
	   sc.log(sc.getContextPath()+" is deployed at"+ new Date());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc=null;
		end=System.currentTimeMillis();
		//get ServletContext
		sc=sce.getServletContext();
		sc.log(sc.getContextPath()+" is undeployed at"+new Date());
		sc.log(sc.getContextPath()+" is in runnning for"+(end-start)+"ms");
	}
	
	
	
}
