package APIVerification;

import org.json.JSONArray;
import org.json.JSONObject;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import junit.framework.Assert;
import utils.ExtendreportListener;

public class APIcodeValidation extends ExtendreportListener {

	public static void validatestatuscode(Response response,int statuscode) {
		try {
			Assert.assertEquals(response.getStatusCode(),statuscode);
			test.log(LogStatus.PASS, "Successfull Status Code "+ response.getStatusCode());	
		}catch(AssertionError e) {
		test.log(LogStatus.FAIL, e.fillInStackTrace());
		}catch(Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
		public static void validatekey(Response response,String key) {
			try {
			JSONArray array=new JSONArray(response.getBody().asString());
			for(int i=0;i<array.length();i++) {
				//System.out.println(array.get(i));
				JSONObject obj=array.getJSONObject(i);
				test.log(LogStatus.PASS, "Successfull validated Key"+ obj.get(key));
			}
			}catch(AssertionError e) {
				test.log(LogStatus.FAIL, e.fillInStackTrace());
				}
			}
		public static void datetimeresponse(Response response) {
			try {
			long time=response.time();
			test.log(LogStatus.PASS, "Successfull validated Key"+ time);
			}catch(Exception e) {
				test.log(LogStatus.FAIL, e.fillInStackTrace());
			}
		}

}
	

