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
		request.setCharacterEncoding("UTF-8");          // ���ñ����ֹ���ĳ�������
       try {
    	   HttpSession session = request.getSession();
    	   String fromid = session.getAttribute("id").toString();
    	   String info = request.getParameter("content");  // ��ȡ������
    	   Notice n = new Notice(fromid,info);
    	   n.add();
    	   Message m = new Message();
    	   
           // ���ύ������ҳ��������null�ж�
           info = (info == null)? "" : "!!!����:"+info;
           m.notice = info;
           response.sendRedirect("Notice.jsp");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
