package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oAbangong.mvc.model.Diary;


public class SelectDiaryByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String t = request.getParameter("i_date");
			Diary d = new Diary();
			ArrayList<Diary> dList = d.selectAlllikeT(t);
			request.setAttribute("dList", dList);
			request.getRequestDispatcher("ShowDiary.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
