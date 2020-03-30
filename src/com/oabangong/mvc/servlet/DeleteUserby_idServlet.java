package com.oabangong.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oAbangong.mvc.model.User;

public class DeleteUserby_idServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String id = request.getParameter("id"); 
			System.out.println(id);
			User u = new User();
			 boolean bool = u.deleteUserById(id);
			 if(bool){request.getRequestDispatcher("Success.jsp").forward(request, response);}
			 else{request.getRequestDispatcher("Failure.jsp").forward(request, response);}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
