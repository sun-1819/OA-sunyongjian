package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.EmailInfo;


public class ShowInfoById extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {System.out.println("进来了");
		HttpSession session = request.getSession();
		 String id = session.getAttribute("id").toString();
			ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
			EmailInfo emi = new EmailInfo();
			uList = emi.queryInfoById(id);
			if(uList != null){
				int i = 0;
				System.out.println("进来了null");
				
				request.setAttribute("tList", uList);
				request.getRequestDispatcher("ShowSingleInfo.jsp?i=0").forward(request, response);
				/*response.sendRedirect("ShowInfo.jsp");*/
			}else{
				System.out.println("defaultkong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
