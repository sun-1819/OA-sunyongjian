package com.oabangong.mvc.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oabangong.mvc.tools.Dbutils;
import com.oabangong.mvc.tools.FileProcess;


public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	try {
		FileProcess fileprocess = new FileProcess();
		HashMap<String,String> map=fileprocess.getParameter(request);
		String name = map.get("name");
		String id_card = map.get("id_card");
		String sex ="1";
		String part = id_card.substring(16, 17);
		if(Integer.parseInt(part) % 2 != 0){
			sex ="ÄÐ";
		}else{
			sex ="Å®";
		}
		String year = id_card.substring(6, 10);
		Calendar cal = Calendar.getInstance();
		int nowyear = cal.get(Calendar.YEAR);
		int nianling = nowyear-Integer.valueOf(year);
		String age = Integer.toString(nianling);
	    System.out.println(age+"Ëê"+sex);
		String tel = map.get("phone");
	    String role = map.get("role");
		String picture = map.get("picture");
		HttpSession session = request.getSession();
		Object i= session.getAttribute("id");
		String playerid=i.toString();
		String sql = "insert into user(name,sex,age,id_card,tel,role,picture,playerid) values('"+name+"','"+sex+"','"+age+"','"+id_card+"','"+tel+"','"+role+"','"+picture+"','"+playerid+"')";
		
		Dbutils db = new Dbutils();
		int result = db.updateData(sql);
		if(result != -1){
		String sql1 = "select id from user where id_card ='"+id_card+"';";
		List<Map<String,String>>  lmap = db.queryData(sql1);
		Map<String,String> map1 = lmap.get(0);
		request.setAttribute("idmap", map1);
		request.getRequestDispatcher("Personnel/ShowId.jsp").forward(request, response);
		}else{
			response.sendRedirect("Failure.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
