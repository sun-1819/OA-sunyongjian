package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oAbangong.mvc.model.User;


public class SelectUserby_idServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {String id = request.getParameter("id"); 
		System.out.println("get"+id);
		    User u = new User(id);
		    User u1 = u.queryUserById();
		    
		    
			 if(u1!=null){
			 request.setAttribute("user", u1);
				request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
			 }else{response.sendRedirect("Failure.jsp");
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
