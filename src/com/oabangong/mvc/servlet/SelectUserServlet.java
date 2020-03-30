package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oAbangong.mvc.model.User;


public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		try {
			ArrayList<User> uList = new ArrayList<User>();
			User u = new User();
			uList=u.selectAllUser();
			request.setAttribute("uList", uList);
			request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	/**	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			ArrayList<User> uList = new ArrayList<User>();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String  sex = request.getParameter("sex");
			String id_card = request.getParameter("id_card");
			String tel = request.getParameter("tel");
			String role="";
			if(request.getParameter("role")!=null){
			  role = request.getParameter("role");
			}
			
			String status = request.getParameter("status");
			String playerid = request.getParameter("playerid");
			 User u = new User( id, name, sex, id_card, tel, role, status,playerid);
			uList = u.jointSql(u);
			request.setAttribute("uList", uList);
			request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
