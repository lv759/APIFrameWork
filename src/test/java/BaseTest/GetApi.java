package BaseTest;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import APIVerification.APIcodeValidation;
import APIbuilder.APIPostbuilder;
import APIconfig.APIpath;
import APIconfig.Headerconfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApi extends Basetest {
	@Test
	public void getTest() {
		
		//RestAssured.baseURI="http://localhost:3000";
		Response response=RestAssured.given().when().get(APIpath.APIclass.Get_All_User);
	//System.out.println(response.getStatusCode());
		APIcodeValidation.validatestatuscode(response, 200);
	}
}
