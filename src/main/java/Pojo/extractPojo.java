package Pojo;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
public class extractPojo {
	@Test
	public void callAPIPojo() {
	RestAssured.baseURI="https://reqres.in/api/users?page=2";
	
	user us=(user) RestAssured.given().when().get().as(user.class);
	//System.out.println(us.toString());
	List<Datapojo> lt=us.getData();
	for(int i=0;i<lt.size();i++) {
		System.out.println(lt.get(i));
	}
	}
}
