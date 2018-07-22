package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.vo.UserDetailsVO;

@WebServlet("/loginurl")
public class LoginHelperServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 String user=null,pwd=null;
		 HttpSession ses=null;
		 UserDetailsVO vo=null;
		 RequestDispatcher rd=null;
		//read form data
		user=req.getParameter("uname");
		pwd=req.getParameter("pwd");
		//prepare vO having user,pwd details
		vo=new UserDetailsVO();
		vo.setUsername(user);
		vo.setPassword(pwd);
		
		//validate Credentials
		if(user.equals("raja") && pwd.equals("rani")){
		  ses=req.getSession();
		  ses.setAttribute("userDetails",vo);
		  //forward to InBox Servlet
		  rd=req.getRequestDispatcher("/inboxurl");
		  rd.forward(req,res);
		}
		else{
			req.setAttribute("errMsg","Invalid Credentials");
			 rd=req.getRequestDispatcher("/login.jsp");
			  rd.forward(req,res);
		}
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
