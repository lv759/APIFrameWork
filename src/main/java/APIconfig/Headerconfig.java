package APIconfig;

import java.util.HashMap;
import java.util.Map;

public class Headerconfig {

	public static Map<String,String> defaultheaders(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("Content-Type", "application/json");
		return map;
	}
	
	public static Map<String,String> headerXML(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("Content-Type", "text/xml");
		return map;
	}
	public static Map<String,String> basicAuth(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", "antlabs20@gmail.com");
		map.put("password", "Lokh@1991");
		return map;
	}
	public static void main(String[] args) {
		Headerconfig ht=new Headerconfig();
		System.out.println(ht.defaultheaders());
		System.out.println(ht.headerXML());
		System.out.println(ht.basicAuth());
	}

}
