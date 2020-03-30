package com.oabangong.mvc.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileProcess {

	public HashMap<String,String>getParameter(HttpServletRequest request){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			InputStream input = null;
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload  upload = new ServletFileUpload(factory);
			FileItemIterator  iter =upload.getItemIterator(request);
			while(iter.hasNext()){
				FileItemStream stream = iter.next();
			input=stream.openStream();
			boolean bool=stream.isFormField();
			String key=stream.getFieldName();
			System.out.println(key);
			if(bool){
				InputStreamReader inputstreamreader = new InputStreamReader(input,"utf-8");
				BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
				String value = bufferedreader.readLine();
				map.put(key, value);
				inputstreamreader.close();
				bufferedreader.close();
				
			}else{
				String filename =stream.getName();
				if(filename!=""&&filename!=null){
				System.out.println(filename);
				String tomcatPath = request.getSession().getServletContext().getRealPath("/resource");
				
				File target = new File(tomcatPath+"/"+filename);
				FileOutputStream output = new FileOutputStream(target);
				int size =0;
				byte[]b = new byte[1024];
				while((size = input.read(b))!=-1){
					output.write(b, 0, size);
				}
				map.put(key, filename);
				output.close();}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return map;
	}

}
