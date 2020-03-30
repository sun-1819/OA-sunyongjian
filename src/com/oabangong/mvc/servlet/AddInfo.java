package com.oabangong.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.EmailInfo;


public class AddInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String name = request.getParameter("name");
			System.out.println(name);
			String toid = request.getParameter("toid");
			System.out.println(toid);
			HttpSession session = request.getSession();
			String fromid = session.getAttribute("id").toString();
			System.out.println(fromid);
			String mailbody = request.getParameter("mailbody");
			EmailInfo eif = new EmailInfo(name,fromid,toid,mailbody);
			int num = eif.addInfo();
			if(num != -1){
				request.getRequestDispatcher("Success.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
