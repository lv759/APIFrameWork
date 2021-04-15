package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class parsedynamicJSON {
	public static void parseObject(JSONObject json,String Key) {
		System.out.println(json.has(Key));
		System.out.println(json.get(Key));
	}
	
	public static void getJSONdata(JSONObject json,String Key) {
		boolean exist=json.has(Key);
		Iterator<?> keys;
		String nextKeys;
		if(!exist) {
			keys=json.keys();
			while(keys.hasNext()) {
				nextKeys=(String) keys.next();
				try {
					if(json.get(nextKeys) instanceof JSONObject) {
						if(exist==false) {
							getJSONdata(json.getJSONObject(nextKeys),Key);
						}
					}else if(json.get(nextKeys) instanceof JSONArray) {
				JSONArray array=json.getJSONArray(nextKeys);
				for(int i=0;i<array.length();i++) {
					String inner= array.get(i).toString();
					JSONObject obj=new JSONObject(inner);
					if(exist==false) {
						getJSONdata(obj,Key);
					}
				}
					}
				}catch(Exception e) {
					
				}
			}
			
		}else {
			parseObject( json, Key);
		}
	}

	public static void main(String[] args) {
		
		String inputjson="{\r\n" + 
				"\"claim_loss_type_cd\": \"TEL\",\r\n" + 
				"\"claim_type\": \"002\",\r\n" + 
				"\"claim_reason\": \"001\",\r\n" + 
				"\"policy_number\": \"1234kk3366ff664\",\r\n" + 
				"\"info\": {\r\n" + 
				"    \"ApplicationContext\": {\r\n" + 
				"        \"country\": \"US\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		JSONObject obj=new JSONObject(inputjson);
		
		 getJSONdata( obj, "country");
	}
}
