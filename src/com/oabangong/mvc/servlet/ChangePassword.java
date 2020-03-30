package com.oabangong.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.Message;
import oAbangong.mvc.model.User;
import oAbangong.mvc.model.UserService;


public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			String pw = request.getParameter("password0");
			String password = request.getParameter("password");
			UserService us = new UserService();
			String result = us.login(id, pw);
		    User u = new User();
		    
			//3.根据返回值选择视图 
			if(result.equals(Message.LOGIN_ERROR)){
				response.sendRedirect("ChangePassword.jsp?ccv=1");
			}else{
				u.changePassword(id, password);
				response.sendRedirect("Success.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
