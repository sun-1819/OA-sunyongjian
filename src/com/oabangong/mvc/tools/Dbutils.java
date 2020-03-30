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
		
		
		//��ȡ����
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
				//����
				int result = stmt.executeUpdate(sql);
				//System.out.println(result);
				return result;
				//�ر���Դ
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			return -1;
			
			
		}
		
		//select:��ѯ
		public List<Map<String,String>> queryData(String sql){
			List<Map<String,String>> rsList = new ArrayList<Map<String,String>>();
			try {
				getConnection();
				//�����
				rs = stmt.executeQuery(sql);
				//������Ľṹ����
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
		
		//����
		public int[] batchData(ArrayList<String> sqlList){
			
			try {
				getConnection();
				//���е�sql��䶼������������
				for(int i = 0;i < sqlList.size();i++){
					stmt.addBatch(sqlList.get(i));
				}
				
				//ִ��
				int [] result  = stmt.executeBatch();
				
				return result;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			return null;
			
		}
		
		
		//�ر�
		public void close(){
			try {
				//��׳��
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



