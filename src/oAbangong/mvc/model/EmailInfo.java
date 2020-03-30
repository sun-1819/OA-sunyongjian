package oAbangong.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oabangong.mvc.tools.Dbutils;

public class EmailInfo {
	private String id;
	private String name;
	private String fromid;
	private String toid;
	private String mailbody;
	private String status;
	private String time;
	
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

	public String getMailbody() {
		return mailbody;
	}

	public void setMailbody(String mailbody) {
		this.mailbody = mailbody;
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

	public EmailInfo() {
		super();
	}
	
	public EmailInfo(String name, String fromid, String toid, String mailbody) {
		super();
		this.name = name;
		this.fromid = fromid;
		this.toid = toid;
		this.mailbody = mailbody;
	}

	public EmailInfo(String id, String name, String fromid, String toid, String mailbody, String status) {
		super();
		this.id = id;
		this.name = name;
		this.fromid = fromid;
		this.toid = toid;
		this.mailbody = mailbody;
		this.status = status;
	}
	
	public EmailInfo(String id, String name, String fromid, String toid, String mailbody, String status, String time) {
		super();
		this.id = id;
		this.name = name;
		this.fromid = fromid;
		this.toid = toid;
		this.mailbody = mailbody;
		this.status = status;
		this.time = time;
	}
	public int addInfo(){
		
			String sql ="insert into emailinfo(name,fromid,toid,mailbody)values('"+name+"','"+fromid+"','"+toid+"','"+mailbody+"')";
			Dbutils db = new Dbutils();
			int result = db.updateData(sql);
			 return result;
		
		}
	public String selectNumInfo(String id ){
		String num = null;
		try {String sql = "select count(*) from emailinfo where toid ='"+id+"' and status = '未读'";
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
	public ArrayList<EmailInfo> selectAllInfo(){
		ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
		try {
			String sql ="select * from emailinfo";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				EmailInfo temp = new EmailInfo(hashMap.get("id"),hashMap.get("name"),hashMap.get("fromid"),hashMap.get("toid"),hashMap.get("mailbody"),hashMap.get("status"),hashMap.get("time"));
				//将User添加到List中
				uList.add(temp);
			}
			return uList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
	public ArrayList<EmailInfo> selectAllInfoDefault(String id){
		
		String sql ="select * from emailinfo where  toid ='"+id+"' and status = '未读' ";
		ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
		try {
			
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				EmailInfo temp = new EmailInfo(hashMap.get("id"),hashMap.get("name"),hashMap.get("fromid"),hashMap.get("toid"),hashMap.get("mailbody"),hashMap.get("status"),hashMap.get("time"));
				//将User添加到List中
				uList.add(temp);
			}
			return uList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
	public ArrayList<EmailInfo> queryInfoByinfoId( String id){
		ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
		try {
			String sql = "select * from emailinfo where id like '"+id+"'";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> rsMap = rsList.get(i);
			
			EmailInfo temp = new EmailInfo(rsMap.get("id"),rsMap.get("name"),rsMap.get("fromid"),rsMap.get("toid"),rsMap.get("mailbody"),rsMap.get("status"),rsMap.get("time"));
			
			uList.add(temp);}
			return uList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

}
	public ArrayList<EmailInfo> queryInfoById( String id){
		ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
		try {
			String sql = "select * from emailinfo where fromid like '"+id+"'";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> rsMap = rsList.get(i);
			
			EmailInfo temp = new EmailInfo(rsMap.get("id"),rsMap.get("name"),rsMap.get("fromid"),rsMap.get("toid"),rsMap.get("mailbody"),rsMap.get("status"),rsMap.get("time"));
			
			uList.add(temp);}
			return uList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean updateInfo(String id){
		try {
			String sql = "update emailinfo set status = '已读' where id ="+id+"";
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
	public boolean deleteInfoById(String id){
		try {String sql = "delete from emailinfo where id = "+id+"";
		Dbutils db = new Dbutils();
		int result = db.updateData(sql);
		if(result != -1){
			return true;
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return false;
	}
		
public ArrayList<EmailInfo> selectSendInfo(String fromid){
		
		String sql ="select * from emailinfo where  fromid ='"+fromid+"'  ";
		ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
		try {
			
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				EmailInfo temp = new EmailInfo(hashMap.get("id"),hashMap.get("name"),hashMap.get("fromid"),hashMap.get("toid"),hashMap.get("mailbody"),hashMap.get("status"),hashMap.get("time"));
				//将User添加到List中
				uList.add(temp);
			}
			return uList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}	
	
public ArrayList<EmailInfo> selectReceiveInfo(String toid){
	
	String sql ="select * from emailinfo where  toid ='"+toid+"' ";
	ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
	try {
		
		Dbutils db = new Dbutils();
		List<Map<String,String>> rsList = db.queryData(sql);
		//实例化一个List<User>
		for(int i = 0;i < rsList.size();i++){
			Map<String,String> hashMap = rsList.get(i);
			EmailInfo temp = new EmailInfo(hashMap.get("id"),hashMap.get("name"),hashMap.get("fromid"),hashMap.get("toid"),hashMap.get("mailbody"),hashMap.get("status"),hashMap.get("time"));
			//将User添加到List中
			uList.add(temp);
		}
		return uList;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}		
}

