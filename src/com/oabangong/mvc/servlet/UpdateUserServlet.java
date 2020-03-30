package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String id = request.getParameter("id");
			String name =request.getParameter("name");
			String id_card = request.getParameter("id_card");
			String tel = request.getParameter("tel");
			String role = request.getParameter("role");
			HttpSession session = request.getSession();
			Object i= session.getAttribute("id");
			String playerid=i.toString();
			User u = new User(id,name,id_card,tel,role,playerid);
			
			boolean bool = u.updateUser();
			if(bool){
			request.getRequestDispatcher("Success.jsp").forward(request, response);}
			else{request.getRequestDispatcher("Failure.jsp").forward(request, response);}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
