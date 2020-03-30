package oAbangong.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oabangong.mvc.tools.Dbutils;

public class Diary {
	private String id;
	private String tittle;
	private String content;
	private String fromid;
	private String pri;
	private String time;
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String gettittle() {
		return tittle;
	}

	public void settittle(String tittle) {
		this.tittle = tittle;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getpri() {
		return pri;
	}

	public void setpri(String pri) {
		this.pri = pri;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Diary() {
		super();
	}
	
	public Diary(String tittle, String fromid) {
		super();
		this.tittle = tittle;
		this.fromid = fromid;
		
		
	}

	public Diary(String tittle, String fromid, String pri) {
		super();
		this.tittle = tittle;
		this.fromid = fromid;
		this.pri = pri;
	}

	public Diary(String tittle, String content, String fromid, String pri) {
		super();
		this.tittle = tittle;
		this.content = content;
		this.fromid = fromid;
		this.pri = pri;
	}

	
	
	public Diary(String id, String tittle, String fromid, String pri, String time) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.fromid = fromid;
		this.pri = pri;
		this.time = time;
	}
	
	public Diary(String id, String tittle, String content, String fromid, String pri, String time) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.content = content;
		this.fromid = fromid;
		this.pri = pri;
		this.time = time;
	}

	public int addDiary(){
		
			String sql ="insert into Diary(tittle,content,fromid,pri)values('"+tittle+"','"+content+"','"+fromid+"','"+pri+"')";
			Dbutils db = new Dbutils();
			int result = db.updateData(sql);
			 return result;
		
		}
	public String selectNum(String id ){
		String num = null;
		try {String sql = "select count(*) from Diary where toid ='"+id+"' and pri = '未读'";
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
	public ArrayList<Diary> selectAllThree(){
		ArrayList<Diary> dList = new ArrayList<Diary>();
		try {
			String sql ="select * from Diary where pri = '3'";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				Diary temp = new Diary(hashMap.get("id"),hashMap.get("tittle"),hashMap.get("content"),hashMap.get("fromid"),hashMap.get("pri"),hashMap.get("time"));
				//将User添加到List中
				dList.add(temp);
			}
			return dList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
	public ArrayList<Diary> selectAllTwo(){
		ArrayList<Diary> dList = new ArrayList<Diary>();
		try {
			String sql ="select * from Diary where pri = '2'";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				Diary temp = new Diary(hashMap.get("id"),hashMap.get("tittle"),hashMap.get("content"),hashMap.get("fromid"),hashMap.get("pri"),hashMap.get("time"));
				//将User添加到List中
				dList.add(temp);
			}
			return dList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
	public ArrayList<Diary> selectAlllikeT(String time){
		
		String sql ="select * from Diary where  time like '%"+time+"%'";
		ArrayList<Diary> dList = new ArrayList<Diary>();
		try {
			
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				Diary temp = new Diary(hashMap.get("id"),hashMap.get("tittle"),hashMap.get("content"),hashMap.get("fromid"),hashMap.get("pri"),hashMap.get("time"));
				//将User添加到List中
				dList.add(temp);
			}
			return dList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
	public ArrayList<Diary> queryById( String id){
		ArrayList<Diary> dList = new ArrayList<Diary>();
		try {
			String sql = "select * from Diary where fromid like '"+id+"'";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> rsMap = rsList.get(i);
			
			Diary temp = new Diary(rsMap.get("id"),rsMap.get("tittle"),rsMap.get("fromid"),rsMap.get("toid"),rsMap.get("pri"),rsMap.get("time"));
			
			dList.add(temp);}
			return dList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean update(String id,String pri){
		try {
			String sql = "update user set pri = '"+pri+"' where id ="+id+"";
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
		try {String sql = "delete from Diary where id = "+id+"";
		Dbutils db = new Dbutils();
		int result = db.updateData(sql);
		if(result != -1){
			return true;
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return false;
	}
	public ArrayList<Diary> queryByjin( String fromid,String tittle,String pri){
		ArrayList<Diary> dList = new ArrayList<Diary>();
		String sql="select * from diary where ";
		try {
			
			if(!pri.equals("") && pri != null){
			    sql += "pri like '%"+pri+"%' and ";
			    //System.out.println(111111111);
			}
			if(!tittle.equals("") && tittle != null){
			    sql += "tittle like '%"+tittle+"%' and ";
			    //System.out.println(111111111);
			}
			if(!tittle.equals("") && tittle != null){
			    sql += "fromid like %"+fromid+"% and ";
			    //System.out.println(111111111);
			}
			
			sql = sql.endsWith(" and ") ? sql.substring(0,sql.lastIndexOf(" and ")) : sql;
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				Diary temp = new Diary(hashMap.get("id"),hashMap.get("tittle"),hashMap.get("content"),hashMap.get("fromid"),hashMap.get("pri"),hashMap.get("time"));
				//将User添加到List中
				dList.add(temp);
			}
			System.out.println(dList.size());
			return dList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Diary queryByDiaryId( String id){
		Diary temp = new Diary();
		try {
			String sql = "select * from Diary where id like '"+id+"'";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> rsMap = rsList.get(i);
			
			 temp = new Diary(rsMap.get("id"),rsMap.get("tittle"),rsMap.get("fromid"),rsMap.get("toid"),rsMap.get("pri"),rsMap.get("time"));
			
			}
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
