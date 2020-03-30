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
			//判断是否存在此用户名
			if(!rsList.isEmpty()){
				Map<String,String> rsMap = rsList.get(0);
				String pwFromMysql = rsMap.get("password");
				String role = rsMap.get("role");
				//判断密码
				if(pw.equals(pwFromMysql)){
					if(role.equals("人事管理员")){
						//跳转到员工的工作菜单
						message = "人事管理员" ;
					}else if(role.equals("经理")){
						//跳转到员工的管理员菜单
						message = "经理";
					}else{
						//跳转到员工的其他菜单
						message = "普通员工";
					}
				}else{
					//密码不正确
					message = Message.LOGIN_ERROR;
					
				}
				
			}else{
				//没有此用户名
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
