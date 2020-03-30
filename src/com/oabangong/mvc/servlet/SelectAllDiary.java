package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.Diary;
import oAbangong.mvc.model.User;


public class SelectAllDiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession();
			Diary d = new Diary();
			ArrayList<Diary> dList = d.selectAllThree();
			ArrayList<Diary> ddList = d.selectAllTwo();
			String id = session.getAttribute("id").toString();
			/*User u = new User(id);
			u = u.queryUserById();*/
			if(session.getAttribute("pri").toString().equals("1")){
				System.out.println("30servlet没问题");
				 dList.addAll(ddList);
				 request.setAttribute("dList", dList);
					request.getRequestDispatcher("ShowDiary.jsp").forward(request, response);
				/*if(w){
					System.out.println("33servlet没问题");
					request.setAttribute("dList", dList);
					request.getRequestDispatcher("ShowDiary.jsp").forward(request, response);
				}else{
					System.out.println("37servlet没问题");
				}*/
			}else{
				request.setAttribute("dList", dList);
				request.getRequestDispatcher("ShowDiary.jsp").forward(request, response);
			}
			System.out.println("41servlet没问题");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

}
