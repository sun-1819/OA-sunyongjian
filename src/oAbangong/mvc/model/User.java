package oAbangong.mvc.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oabangong.mvc.tools.Dbutils;

public class User {
	private String id;
	private String name;
	private String password;
	private String sex;
	private String age;
	private String id_card;
	private String tel;
	private String role;
	private String status;
	private String picture;
	private String playerid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getPlayerid() {
		return playerid;
	}
	public void setPlayerid(String playerid) {
		this.playerid = playerid;
	}
	
	public User() {
		super();
	}
	
	public User(String id) {
		super();
		this.id = id;
	}
	
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public User(String id, String name, String tel,String status) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		
		this.status = status;
	}
	public User(String id, String name, String id_card, String tel, String role, String playerid) {
		super();
		this.id = id;
		this.name = name;
		this.id_card = id_card;
		this.tel = tel;
		this.role = role;
		this.playerid = playerid;
	}
	public User(String id, String name, String sex, String id_card, String tel, String role, String status,
			String playerid) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.id_card = id_card;
		this.tel = tel;
		this.role = role;
		this.status = status;
		this.playerid = playerid;
	}
	public User( String name, String password, String sex, String age,String id_card, String tel, String role,
			String status, String picture, String playerid) {
		super();
		
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.id_card = id_card;
		this.tel = tel;
		this.role = role;
		this.status = status;
		this.picture = picture;
		this.playerid = playerid;
	}
	
	public User(String id, String name, String password, String sex, String age, String id_card, String tel,
			String role, String status, String picture, String playerid) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.id_card = id_card;
		this.tel = tel;
		this.role = role;
		this.status = status;
		this.picture = picture;
		this.playerid = playerid;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", age=" + age
				+ ", id_card=" + id_card + ", tel=" + tel + ", role=" + role + ", status=" + status + ", picture="
				+ picture + ", playerid=" + playerid + "]";
	}
	//条件模糊查询
	public ArrayList<User> jointSql(User u){
		String sql = "select * from user where ";
		System.out.println(u);
		ArrayList<User> uList = new ArrayList<User>();
		//System.out.println(u.getId());
		try {
			if(!u.getId().equals("") && u.getId() != null){
			    sql += "id like '%"+u.getId()+"%' and ";
			    //System.out.println(111111111);
			}
		
			if(!u.getName().equals("") && u.getName() != null){
				sql = sql + "name like '%"+u.getName()+"%' and ";
			}
			/*if(!u.getPassword().equals("") && u.getPassword() != null){
				sql = sql + "password like '%"+u.getPassword()+"%' and ";
			}*/
			System.out.println(1111111111);
			if(!u.getSex().equals("") && u.getSex() != null){
				sql = sql + "sex like '%"+u.getSex()+"%' and ";
			}
			/*if(!u.getAge().equals("") && u.getAge() != null){
				sql = sql + "age like '%"+u.getAge()+"%' and ";
			}*/
			System.out.println(1111222222);
			if(!u.getId_card().equals("") && u.getId_card() != null){
				sql = sql + "id_card like '%"+u.getId_card()+"%' and ";
			}
			if(!u.getTel().equals("") && u.getTel() != null){
				sql = sql + "tel like '%"+u.getTel()+"%' and ";
			}
			/*if(u.getRole() == null){
				sql=sql+"";
			}*/
			if(!u.getRole().equals("") && u.getRole() != null){
				System.out.println("出错了");
				sql = sql + "role like '%"+u.getRole()+"%' and ";
			}
			System.out.println(1);
			/*if(!u.getStatus().equals("") && u.getStatus() != null){
				sql = sql + "status like '%"+u.getStatus()+"%' and ";
			}*/
			System.out.println(2);
			if(!u.getPlayerid().equals("") && u.getPlayerid() != null){
				sql = sql + "playerid like '%"+u.getPlayerid()+"%' and ";
			}
			System.out.println(3);
            sql = sql.endsWith(" and ") ? sql.substring(0,sql.lastIndexOf(" and ")) : sql;
			sql = sql.endsWith(" where ") ? sql.substring(0, sql.lastIndexOf(" where ")):sql;
			System.out.println(sql);
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//System.out.println(rsList.size());
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				User temp = new User(hashMap.get("id"),hashMap.get("name"),hashMap.get("password"),hashMap.get("sex"),hashMap.get("age"),hashMap.get("id_card"),hashMap.get("tel"),hashMap.get("role"),hashMap.get("status"),hashMap.get("picture"),hashMap.get("playerid"));
				//将User添加到List中
				uList.add(temp);
			}
			System.out.println(uList.size());
			return uList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//全查询
			public ArrayList<User> selectAllUser(){
				ArrayList<User> uList = new ArrayList<User>();
				try {
					String sql ="select * from user";
					Dbutils db = new Dbutils();
					List<Map<String,String>> rsList = db.queryData(sql);
					//实例化一个List<User>
					for(int i = 0;i < rsList.size();i++){
						Map<String,String> hashMap = rsList.get(i);
						User temp = new User(hashMap.get("id"),hashMap.get("name"),hashMap.get("password"),hashMap.get("sex"),hashMap.get("age"),hashMap.get("id_card"),hashMap.get("tel"),hashMap.get("role"),hashMap.get("status"),hashMap.get("picture"),hashMap.get("playerid"));
						//将User添加到List中
						uList.add(temp);
					}
					return uList;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return null;
	}
			public User queryUserById(){
				try {
					String sql = "select * from user where id like '"+id+"'";
					Dbutils db = new Dbutils();
					List<Map<String,String>> rsList = db.queryData(sql);
					if(rsList.size()!=0){
					Map<String,String> rsMap = rsList.get(0);
					
					User temp = new User(rsMap.get("id"),rsMap.get("name"),rsMap.get("password"),rsMap.get("sex"),rsMap.get("age"),rsMap.get("id_card"),rsMap.get("tel"),rsMap.get("role"),rsMap.get("status"),rsMap.get("picture"),rsMap.get("playerid"));
					
					return temp;}else{return null;}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return null;
			}
			
			public boolean deleteUserById(String id){
				try {String sql = "delete from user where id = "+id+"";
				Dbutils db = new Dbutils();
				int result = db.updateData(sql);
				if(result != -1){
					return true;
				}
					
				} catch (Exception e) {
					e.printStackTrace();
				}return false;
			}
			public boolean updateUserSelf(){
				try {
					String sql = "update user set name = '"+name+"',tel = '"+tel+"',status = '"+status+"' where id = "+id+"";
					Dbutils db = new Dbutils();
					int result = db.updateData(sql);
					if(result != -1){
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public boolean updateSelfPicture(String id,String picture){
				try {
					String sql = "update user set picture = '"+picture+"' where id = "+id+"";
					Dbutils db = new Dbutils();
					int result = db.updateData(sql);
					if(result != -1){
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public boolean changePassword(String id,String password){
				try {
					String sql = "update user set password = '"+password+"' where id = "+id+"";
					Dbutils db = new Dbutils();
					int result = db.updateData(sql);
					if(result != -1){
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public boolean updateUser(){
					try {
						String sql = "update user set name = '"+name+"',id_card = '"+id_card+"',tel = '"+tel+"',role = '"+role+"',playerid = '"+playerid+"'  where id = '"+id+"'";
						Dbutils db = new Dbutils();
						int result = db.updateData(sql);
						if(result != -1){
							return true;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return false;
				
			}
				
}
