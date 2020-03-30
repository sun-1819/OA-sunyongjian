package com.oabangong.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.Message;
import oAbangong.mvc.model.UserService;




public class DiffUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//servlet的域对象：request,session,application
		HttpSession session = request.getSession();
		try {
			//1.接收用户的请求
			String id = request.getParameter("id");  //null
			String pw = request.getParameter("password");
			System.out.println(pw);
			//2.选择合适的模型
			UserService us = new UserService();
			String result = us.login(id, pw);
		
			//3.根据返回值选择视图 
			if(result.equals(Message.LOGIN_ERROR)){
				response.sendRedirect("Login.jsp?code=1");
			}else if(result.equals("经理")){
				session.setAttribute("id", id);
				session.setAttribute("pri", 1);
				response.sendRedirect("SelectUserFrameset.jsp?");
			}else if(result.equals("人事管理员")){
				session.setAttribute("id", id);
				session.setAttribute("pri", 2);
				response.sendRedirect("SelectUserFrameset.jsp?");
			}else{
				session.setAttribute("id", id);
				session.setAttribute("pri", 3);
				response.sendRedirect("Kidding.jsp?");
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
