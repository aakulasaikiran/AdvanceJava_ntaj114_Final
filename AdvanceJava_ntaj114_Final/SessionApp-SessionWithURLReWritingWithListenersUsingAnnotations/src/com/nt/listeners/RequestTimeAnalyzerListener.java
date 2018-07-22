package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestTimeAnalyzerListener implements ServletRequestListener {
    private long start=0,end=0;
    
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		start=System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequest req=null;
		ServletContext sc=null;
		end=System.currentTimeMillis();
		
		//get request object
		req=sre.getServletRequest();
		//get ServletContext object
		sc=req.getServletContext();
		//get request processing time...
		sc.log(((HttpServletRequest)req).getRequestURI()+" has taken"+ (end-start)+" ms to process the request");
	}
	

}
