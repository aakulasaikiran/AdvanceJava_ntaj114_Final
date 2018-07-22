package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "download", urlPatterns = { "/downloadurl" })
public class DownloadServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     OutputStream os=null;
	     File file=null;
	     ServletContext sc=null;
	     long  length=0;
	     InputStream is=null;
	     byte[] buffer=null;
		
	     //get ServletContext
	     sc=getServletContext();
	     //Locate the file to be downloaded
	     file=new File(sc.getRealPath("/james.png"));
	     //get the length of the file  and set it as response content length
	     length=file.length();
	     res.setContentLengthLong(length);
	     //get file MIME type and set it as response MIME type
	     res.setContentType(sc.getMimeType("/james.png"));
	     //make browser to display the output of this web comp as downloadable file
	     res.addHeader("Content-Disposition","attachment;fileName=james.png");
	     //get InputStream 
	      is=new FileInputStream(file);
	   // get ServletOutputStream
		     os=res.getOutputStream();
	      //buffer
		     buffer=new byte[4096];
		     int bytesRead=0;
		     while((bytesRead=is.read(buffer))!=-1){
		    	 os.write(buffer,0,bytesRead);
		     }
		     //flush and close streams
		     is.close();
		     os.flush();
		     os.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}//class
