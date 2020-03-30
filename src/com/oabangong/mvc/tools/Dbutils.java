package com.oabangong.mvc.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dbutils {
	
		
		private Connection conn = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		
		
		//获取连接
		public void getConnection(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/tf75", "root", "mysql");
				stmt = conn.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//insert,update,delete,create
		public int updateData(String sql){
			try {
				getConnection();
				//更新
				int result = stmt.executeUpdate(sql);
				//System.out.println(result);
				return result;
				//关闭资源
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			return -1;
			
			
		}
		
		//select:查询
		public List<Map<String,String>> queryData(String sql){
			List<Map<String,String>> rsList = new ArrayList<Map<String,String>>();
			try {
				getConnection();
				//结果集
				rs = stmt.executeQuery(sql);
				//结果集的结构对象
				ResultSetMetaData rsmd = rs.getMetaData();
				int count = rsmd.getColumnCount();
				
				while(rs.next()){
					Map<String,String> rsMap = new HashMap<String,String>();
					for(int i = 1;i <= count;i++){
						String columnName = rsmd.getColumnName(i);
						String columnValue = rs.getString(columnName);
						rsMap.put(columnName, columnValue);
					}
					
					rsList.add(rsMap);	
				}
				
				return rsList;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			return null;
		}
		
		//批量
		public int[] batchData(ArrayList<String> sqlList){
			
			try {
				getConnection();
				//所有的sql语句都放置在批量中
				for(int i = 0;i < sqlList.size();i++){
					stmt.addBatch(sqlList.get(i));
				}
				
				//执行
				int [] result  = stmt.executeBatch();
				
				return result;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			return null;
			
		}
		
		
		//关闭
		public void close(){
			try {
				//健壮性
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}



