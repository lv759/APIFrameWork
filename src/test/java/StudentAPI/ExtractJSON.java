package StudentAPI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ExtractJSON {
	
public static void main(String[] args) throws IOException, ParseException {
JSONParser parse=new JSONParser();

FileReader read=new FileReader(".\\jsoninput\\employee.json");
JSONObject obj= (JSONObject) parse.parse(read);
String firstname=(String) obj.get("firstname");
String lastname=(String) obj.get("lastname");
System.out.println(firstname+" "+lastname);

JSONArray array=(JSONArray) obj.get("Address");

for(int i=0;i<array.size();i++) {
	System.out.println(array.get(i));
	JSONObject oj=(JSONObject) array.get(i);
	String city=(String) oj.get("City");
	String State=(String) oj.get("State");
	System.out.println("address i="+i);
	System.out.println("City "+city);
	System.out.println("State "+State);
}


}

}
