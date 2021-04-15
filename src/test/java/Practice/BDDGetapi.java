package Practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import utils.DataCreator;




public class BDDGetapi {
	public static Map map=new HashMap();
//@Test	
 public  void apiget1() {
	
	given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200)
	.body("data.id[1]", equalTo(8))
	 .body("data.first_name",hasItems("Michael","Lindsay"));
}

//@Test	
public void apiPost2() {
	
	map.put("name",DataCreator.getName());
	map.put("job",DataCreator.getJob());
	
	given().body(map).header("content-Type","application/json").accept(ContentType.JSON)
	.when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
}

//@Test	
public void apiPut3() {
	String employeename=DataCreator.getemployeename();
	String employeesalary=DataCreator.getemployeesalary();
	String employeeage= DataCreator.getemployeeage();
	map.put("employee_name",employeename);
	map.put("employee_salary",employeesalary);
	map.put("employee_age",employeeage);
	int id=21;
	baseURI="http://dummy.restapiexample.com/api/v1";
	basePath="/update/"+id;
	given().body(map).header("content-Type","application/json").accept(ContentType.JSON)
	.when().put().then().statusCode(200).assertThat().body("message",equalTo("Successfully! Record has been updated.")).log().all();
}
@Test
public void apidelete4() {
	int id=22;
	baseURI="http://dummy.restapiexample.com/api/v1";
	basePath="/delete/"+id;
	
	Response response= given()
	.when().delete().then().statusCode(200).
	log().all().extract().response();
	String delete=response.asString();
	Assert.assertEquals(delete.contains("Successfully! Record has been deleted"),true);
	
	
}

}
