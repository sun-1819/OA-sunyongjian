package com.oabangong.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oAbangong.mvc.model.Message;
import oAbangong.mvc.model.Notice;

public class SendNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");          // 设置编码防止中文出现乱码
       try {
    	   HttpSession session = request.getSession();
    	   String fromid = session.getAttribute("id").toString();
    	   String info = request.getParameter("content");  // 获取表单内容
    	   Notice n = new Notice(fromid,info);
    	   n.add();
    	   Message m = new Message();
    	   
           // 表单提交到本身页面必须进行null判断
           info = (info == null)? "" : "!!!公告:"+info;
           m.notice = info;
           response.sendRedirect("Notice.jsp");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
