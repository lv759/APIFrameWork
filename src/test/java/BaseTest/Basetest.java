package BaseTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utils.Fileanddev;

public class Basetest {
	@BeforeClass
	public void beforetest()  {
		System.out.println("Config dev detail "+Fileanddev.endev().get("Serverurl"));
		RestAssured.baseURI=Fileanddev.endev().get("Serverurl");
	}
}
