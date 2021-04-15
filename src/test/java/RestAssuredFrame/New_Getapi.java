package RestAssuredFrame;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ExcelsheetData;

public class New_Getapi {
	//@Test
	public void get() {
		RestAssured.baseURI="https://reqres.in/";
		
		BasicAuthScheme auth=new BasicAuthScheme();
		auth.setUserName("lvmm21@gmail.com");
		auth.setPassword("Lokh@1991");
		
		RestAssured.authentication=auth;
		
		RequestSpecification httprequest=RestAssured.given();
		
	Response response=httprequest.request(Method.GET,"/api/users?page=2");
			String out=response.getBody().asString();
			System.out.println("Body Content "+out);
		Assert.assertEquals(out.contains("Michael"), true);
		
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("page"));
		System.out.println(jsonpath.get("per_page"));
		System.out.println(jsonpath.get("total"));
		System.out.println(jsonpath.get("total_pages"));
		System.out.println(jsonpath.get("data"));
			
			int status=response.getStatusCode();
			System.out.println("Status Code"+status);
			Assert.assertEquals(status, 200);
			

			String statusline=response.getStatusLine();
			System.out.println("Status Line"+statusline);
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK");		
					
	}
	@Test(dataProvider="data")
	public void Post(String nam,String sal,String age) {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	/*	Map map=new HashMap();
		map.put("name", "Vishal");
		map.put("salary", "545464");
		map.put("age", "17");*/
		JSONObject obj=new JSONObject();
		obj.put("name", nam);
		obj.put("salary", sal);
		obj.put("age", age);
		RequestSpecification httprequest=RestAssured.given();
		
		
		httprequest.body(obj.toJSONString());
		httprequest.header("content-type","application/json");
		
		Response response=httprequest.request(Method.POST,"/create");
			String out=response.getBody().asString();
			System.out.println(out);
			
			int status=response.getStatusCode();
			System.out.println("Status Code "+status);
			Assert.assertEquals(status, 200);
			

			String statusline=response.getStatusLine();
			System.out.println("Status Line "+statusline);
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
			
		String message=response.jsonPath().get("message");
		System.out.println("Response message "+message);
		Assert.assertEquals(message, "Successfully! Record has been added.");
		
		String contentype=response.header("Content-Type");
		System.out.println(contentype);
		Assert.assertEquals(contentype, "application/json");
		
		
		Headers head=response.headers();			
		
		for(Header ht:head) {
			System.out.println(ht.getName()+"|"+ht.getValue());
		}
			
	}
	@DataProvider(name="data")
	public String[][] getdata() throws IOException{
		String input=System.getProperty("user.dir");
		System.out.println(input);
		String path=input+"//data//exceldata.xlsx";
		int rowcount=ExcelsheetData.RowCount(path, "Sheet1");
		int colcount=ExcelsheetData.CellCount(path, "Sheet1", 1);
		String data[][]=new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
			 data[i-1][j]	=ExcelsheetData.getcellData(path, "Sheet1", i, j);
			}
		}
		//String data[][]= {{"Vishal","10500","31"},{"Jim","11500","21"},{"Tom","12000","23"}};
		return data;
	}
}
