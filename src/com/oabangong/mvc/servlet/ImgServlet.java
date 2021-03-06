package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oabangong.mvc.tools.FileProcess;

import oAbangong.mvc.model.User;


public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			FileProcess fileprocess = new FileProcess();
			HashMap<String,String> map=fileprocess.getParameter(request);
			String picture = map.get("picture");
			HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			User u = new User();
			boolean b = u.updateSelfPicture(id, picture);
			if(b){
				response.sendRedirect("Picture.jsp");
			}else{
				response.sendRedirect("Failure.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
