package com.nt.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
    HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	public String getParameter(String pname){
		String pvalue=null;
		pvalue=request.getParameter(pname);
		if(pname.equalsIgnoreCase("uname")){
			if(pvalue.indexOf("@gmail.com")==-1){
				pvalue=pvalue+"@gmail.com";
			}
			return pvalue;
		}
		return pvalue;
	}//method
	

}//class
