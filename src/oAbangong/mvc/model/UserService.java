package oAbangong.mvc.model;

import java.util.List;
import java.util.Map;


import com.oabangong.mvc.tools.Dbutils;

public class UserService {
	
	
	public String login(String id,String pw){
		String message = "";
		try {
			Dbutils db = new Dbutils();
			String sql = "select password,role from user where id = '"+id+"'";
			List<Map<String,String>> rsList = db.queryData(sql);
			//�ж��Ƿ���ڴ��û���
			if(!rsList.isEmpty()){
				Map<String,String> rsMap = rsList.get(0);
				String pwFromMysql = rsMap.get("password");
				String role = rsMap.get("role");
				//�ж�����
				if(pw.equals(pwFromMysql)){
					if(role.equals("���¹���Ա")){
						//��ת��Ա���Ĺ����˵�
						message = "���¹���Ա" ;
					}else if(role.equals("����")){
						//��ת��Ա���Ĺ���Ա�˵�
						message = "����";
					}else{
						//��ת��Ա���������˵�
						message = "��ͨԱ��";
					}
				}else{
					//���벻��ȷ
					message = Message.LOGIN_ERROR;
					
				}
				
			}else{
				//û�д��û���
				message =  Message.LOGIN_ERROR;
			}
			
			/*System.out.println(rsList.size());*/
			/*System.out.println(rsList.isEmpty());*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
		
		
	}

}
