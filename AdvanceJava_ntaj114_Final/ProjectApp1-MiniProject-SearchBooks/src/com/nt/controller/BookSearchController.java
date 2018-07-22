package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.service.BookSearchService;
import com.nt.service.BookSearchServiceImpl;

public class BookSearchController extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 String category=null;
		 String source=null;
		 BookSearchService service=null;
		 List<BookDTO> listDTO=null;
		 RequestDispatcher rd=null;
		 String target=null;
		//read form data
		category=req.getParameter("category");
		source=req.getParameter("source");
		//create Service class object
		service=new BookSearchServiceImpl();
		try{
		listDTO=service.search(category);
		}
		catch(Exception e){
		 rd=req.getRequestDispatcher("/error.jsp");
		 rd.forward(req,res);
		}
		//keep ListDTO in requestScope to pass to result jsp pages
		req.setAttribute("booksListDTO",listDTO);
		//forward request to result jsp page using rd.forward(-,-)
		if(source.equalsIgnoreCase("html")){
			target="HtmlScreen.jsp";
		}
		else{
			target="ExcelScreen.jsp";
		}
		rd=req.getRequestDispatcher(target);
		rd.forward(req,res);
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
