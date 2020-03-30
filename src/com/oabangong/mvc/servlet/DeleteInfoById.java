package com.oabangong.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oAbangong.mvc.model.EmailInfo;


public class DeleteInfoById extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String id = request.getParameter("id");
			EmailInfo emi = new EmailInfo();
			boolean h = emi.deleteInfoById(id);
			if(h){
				response.sendRedirect("Success.jsp");
			}else{
				response.sendRedirect("Failure.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
