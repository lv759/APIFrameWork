package APIbuilder;

import java.util.HashMap;
import java.util.Map;

public class APIPostbuilder {

	public static Map<String,String> postdata(String id,String name,String Job,String sub){
		Map<String,String> data=new HashMap<String,String>();
		data.put("id", id);
		data.put("name", name);
		data.put("job", Job);
		data.put("subjectId", sub);
		return data;
	}
}
