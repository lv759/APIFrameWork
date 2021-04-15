package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Fileanddev {

	public static Map<String,String> map=new HashMap<String,String>();
	public static Properties prop=new Properties();
	
	public static Map<String,String> endev() {
		String envir=System.getProperty("env");
	String path=System.getProperty("user.dir");
	
		try {
		if(envir.equalsIgnoreCase("dev")){
			
			FileInputStream file=new FileInputStream("C:/Users/VISH/eclipse-workspace/FrameworkRestAssuredAPI/Input/dev.properties");
			prop.load(file);
			map.put("Serverurl", prop.getProperty("Serverurl"));
			map.put("port", prop.getProperty("port"));
			map.put("username", prop.getProperty("username"));
			map.put("password", prop.getProperty("password"));
			
		}else if(envir.equalsIgnoreCase("qa")){
			FileInputStream file1=new FileInputStream("C:/Users/VISH/eclipse-workspace/FrameworkRestAssuredAPI/Input/qa.properties");
			prop.load(file1);
			map.put("Serverurl", prop.getProperty("Serverurl"));
			map.put("port", prop.getProperty("port"));
			map.put("username", prop.getProperty("username"));
			map.put("password", prop.getProperty("password"));
			
		}else if(envir.equalsIgnoreCase("staging")){
			FileInputStream file2=new FileInputStream("C:/Users/VISH/eclipse-workspace/FrameworkRestAssuredAPI/Input/staging.properties");
			prop.load(file2);
			map.put("Serverurl", prop.getProperty("Serverurl"));
			map.put("port", prop.getProperty("port"));
			map.put("username", prop.getProperty("username"));
			map.put("password", prop.getProperty("password"));
			
		}
		}catch(Exception e) {
			
		}
		return map;
	}

	public static Map<String,String> filendev()  {
		if(map==null) {
			map=endev();
		}
		return map;
	}
	public static void main(String[] args) {
		System.out.println(Fileanddev.endev());
		String path=System.getProperty("user.dir");
		System.out.println(path);
	}
}
