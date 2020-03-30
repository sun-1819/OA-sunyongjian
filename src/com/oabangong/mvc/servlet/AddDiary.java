package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.Diary;


public class AddDiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("æπ¿¥¡À");
PrintWriter out = response.getWriter();
			
			Thread.sleep(5000);
			
			out.print("receive info");
			
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String tittle = request.getParameter("name");
			System.out.println(tittle);
			HttpSession session = request.getSession();
			String fromid = session.getAttribute("id").toString();
			System.out.println(fromid);
			String content = request.getParameter("content");
			String pri = request.getParameter("role");
			Diary d = new Diary(tittle,content,fromid,pri);
			int num = d.addDiary();
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
