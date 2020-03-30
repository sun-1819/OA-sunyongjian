package oAbangong.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oabangong.mvc.tools.Dbutils;

public class Email {
	private String id;
	private String picture;
	private String fromid;
	private String toid;
	
	private String status;
	private String time;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getToid() {
		return toid;
	}

	public void setToid(String toid) {
		this.toid = toid;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Email() {
		super();
	}
	
	public Email(String picture, String fromid, String toid) {
		super();
		this.picture = picture;
		this.fromid = fromid;
		this.toid = toid;
		
	}

	public Email(String id, String picture, String fromid, String toid, String status) {
		super();
		this.id = id;
		this.picture = picture;
		this.fromid = fromid;
		this.toid = toid;
		
		this.status = status;
	}
	
	public Email(String id, String picture, String fromid, String toid, String status, String time) {
		super();
		this.id = id;
		this.picture = picture;
		this.fromid = fromid;
		this.toid = toid;
		
		this.status = status;
		this.time = time;
	}
	public int add(){
		
			String sql ="insert into email(picture，fromid,toid)values('"+picture+"','"+fromid+"','"+toid+"')";
			Dbutils db = new Dbutils();
			int result = db.updateData(sql);
			 return result;
		
		}
	public String selectNum(String id ){
		String num = null;
		try {String sql = "select count(*) from email where toid ='"+id+"' and status = '未读'";
		Dbutils db = new Dbutils();
		List<Map<String,String>> rsList = db.queryData(sql);
		Map<String,String> hMap = rsList.get(0);
		num = hMap.get("count(*)");
		if(num != null){
		System.out.println(num);}
		return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}
	public ArrayList<Email> selectAll(){
		ArrayList<Email> uList = new ArrayList<Email>();
		try {
			String sql ="select * from email";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				Email temp = new Email(hashMap.get("id"),hashMap.get("picture"),hashMap.get("fromid"),hashMap.get("toid"),hashMap.get("status"),hashMap.get("time"));
				//将User添加到List中
				uList.add(temp);
			}
			return uList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
	public ArrayList<Email> selectAllDefault(String id){
		
		String sql ="select * from email where  toid ='"+id+"' and status = '未读' ";
		ArrayList<Email> uList = new ArrayList<Email>();
		try {
			
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				Email temp = new Email(hashMap.get("id"),hashMap.get("picture"),hashMap.get("fromid"),hashMap.get("toid"),hashMap.get("status"),hashMap.get("time"));
				//将User添加到List中
				uList.add(temp);
			}
			return uList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
	public ArrayList<Email> queryById( String id){
		ArrayList<Email> uList = new ArrayList<Email>();
		try {
			String sql = "select * from email where fromid like '"+id+"'";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> rsMap = rsList.get(i);
			
			Email temp = new Email(rsMap.get("id"),rsMap.get("picture"),rsMap.get("fromid"),rsMap.get("toid"),rsMap.get("status"),rsMap.get("time"));
			
			uList.add(temp);}
			return uList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean update(String id){
		try {
			String sql = "update user set status = '已读' where id ="+id+"";
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
	public boolean deleteById(String id){
		try {String sql = "delete from email where id = "+id+"";
		Dbutils db = new Dbutils();
		int result = db.updateData(sql);
		if(result != -1){
			return true;
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return false;
	}
		
		
	
		
}
