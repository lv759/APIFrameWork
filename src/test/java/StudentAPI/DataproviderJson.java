package StudentAPI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderJson {
	WebDriver driver;
	@BeforeClass
	public void beforestart() {
		WebDriverManager.chromiumdriver().setup();
		driver=new  ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	@Test(dataProvider="dp")
	public void login(String data) {
		String[] spl=data.split(",");
		driver.get("https://example.testproject.io/web/");
		driver.findElement(By.id("name")).sendKeys(spl[0]);
		driver.findElement(By.id("password")).sendKeys(spl[1]);
		driver.findElement(By.id("login")).click();
	}
	@DataProvider(name="dp")
	public String[] jsondata() throws IOException, ParseException{
		JSONParser hp=new JSONParser();
		FileReader read=new FileReader(".//jsoninput//user.json");
		JSONObject obj=(JSONObject) hp.parse(read);
	JSONArray array=(JSONArray) obj.get("userlogin");
	String str[]=new String[array.size()];
	for(int i=0;i<array.size();i++) {
	JSONObject jt=	(JSONObject) array.get(i);
	String usern= (String)jt.get("username");
	String passw= (String)jt.get("password");
	str[i]=usern+","+passw;
	}
	return str;
	}
}
