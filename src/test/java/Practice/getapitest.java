package Practice;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.*;
import io.restassured.response.Response;

public class getapitest {
	//@Test
	public void getapi() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		Response response=RestAssured.given().param("name","2").when().get();
		System.out.println("GetBody"+response.body().toString());
		System.out.println("Cookies"+response.cookies());
		
		System.out.println("Status Code"+response.statusCode());
		System.out.println("Status Line"+response.statusLine());
		System.out.println(response.prettyPrint());
		//RestAssured.given().param("page", "2").
		//	get().then().statusCode(200).log().all();
		
	}
	
	@Test
	public void getPostAPI() {
		RestAssured.baseURI="https://reqres.in/api/users";
		String json="{\r\n"+"    \"name\": \"morpheus\",\r\n"+"    \"job\": \"leader\"\r\n" + 
				"}";
		RestAssured.given().body(json).post().then().statusCode(201).log().all();
	}

}
