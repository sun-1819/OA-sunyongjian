package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.Diary;


public class SelectDiaryByjin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession();
			String fromid = session.getAttribute("id").toString();
			String tittle = request.getParameter("tittle");
			String pri = request.getParameter("pri");
			Diary d = new Diary();
			ArrayList<Diary> dList = d.queryByjin(fromid, tittle, pri);
			if(dList !=null){
			request.setAttribute("dList", dList);
		  request.getRequestDispatcher("ShowDiary.jsp").forward(request, response);
			}else{
				response.sendRedirect("Failure.jsp");
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
