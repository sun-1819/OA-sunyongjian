package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oabangong.mvc.tools.FileProcess;

import oAbangong.mvc.model.Email;


public class AddEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {

			FileProcess fileprocess = new FileProcess();
			HashMap<String,String> map=fileprocess.getParameter(request);
			String toid = map.get("toid");
			HttpSession session = request.getSession();
			String fromid = session.getAttribute("id").toString();
			String picture = map.get("picture");
			Email e = new Email(picture,fromid,toid);
			int l = e.add();
			if(l !=-1){
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
