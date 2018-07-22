package com.nt.wrappers;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
  private HttpServletResponse response;
  private CharArrayWriter  writer;
	public MyResponse(HttpServletResponse response) {
		super(response);
		this.response=response;
		writer=new CharArrayWriter();
	}
	
	public PrintWriter getWriter(){
		return new PrintWriter(writer);
	}
	
	public String toString(){
		return writer.toString();
	}

}
