package com.oabangong.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.User;

public class UpdateSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   	
   	
   	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String status = request.getParameter("status");
			User u = new User(id,name,tel,status);
			boolean b = u.updateUserSelf();
			if(b){
				response.sendRedirect("Success.jsp");
			}else{
				response.sendRedirect("Failure.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
