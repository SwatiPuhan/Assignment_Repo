package com.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getData(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./configData/taskCommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
		 
	}

}



