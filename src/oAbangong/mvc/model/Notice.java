package oAbangong.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oabangong.mvc.tools.Dbutils;

public class Notice {
	private String id;
	private String fromid;
	private String content;
	private String time;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Notice(String fromid, String content) {
		super();
		this.fromid = fromid;
		this.content = content;
	}

	public Notice(String id, String fromid, String content, String time) {
		super();
		this.id = id;
		this.fromid = fromid;
		this.content = content;
		this.time = time;
	}
	public int add(){
		
		String sql ="insert into notice(fromid，content)values('"+fromid+"','"+content+"')";
		Dbutils db = new Dbutils();
		int result = db.updateData(sql);
		 return result;
	
	}
	public ArrayList<Notice> selectAll(){
		ArrayList<Notice> nList = new ArrayList<Notice>();
		try {
			String sql ="select * from Notice";
			Dbutils db = new Dbutils();
			List<Map<String,String>> rsList = db.queryData(sql);
			//实例化一个List<User>
			for(int i = 0;i < rsList.size();i++){
				Map<String,String> hashMap = rsList.get(i);
				Notice temp = new Notice(hashMap.get("id"),hashMap.get("fromid"),hashMap.get("content"),hashMap.get("time"));
				//将User添加到List中
				nList.add(temp);
			}
			return nList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}
}
