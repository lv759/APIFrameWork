package Practice;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLvalidator {
	@Test
	public void gettut() throws IOException {
		File file=new File("./data/TestXML.xml");
		FileInputStream fl=new FileInputStream(file);
		String str=IOUtils.toString(fl,"UTF-8");
		baseURI="http://www.dneonline.com";
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(str).
		when().
		post("/calculator.asmx").
		then().statusCode(200).log().all();
	}
}
