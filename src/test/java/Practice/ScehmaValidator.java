package Practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ScehmaValidator {

	@Test
	public void gettet() {
		baseURI="https://reqres.in/api";
		
		given().get("/users?page=2").then().
		assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
		statusCode(200).log().all();
	}
}
