package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractJson {
	@Test
	public void jsonextract() {
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		Response response=(Response) RestAssured.given().contentType(ContentType.JSON).log().all().get();
		
		int total=RestAssured.given().contentType(ContentType.JSON).log().all().get().then()
			.extract().path("total");

		JSONArray data=RestAssured.given().contentType(ContentType.JSON).log().all().get().then()
			.extract().path("data");
		
		response.prettyPrint();
		System.out.println(total);
		
		for(int i=0;i<data.length();i++) {
			JSONObject obj=(JSONObject) data.get(i);
			int id=(Integer) obj.get("id");
			String email=(String) obj.get("email");
			String first_name=(String) obj.get("first_name");
			String last_name=(String) obj.get("last_name");
			String avatar=(String) obj.get("avatar");
		}
		
		
	}
}
