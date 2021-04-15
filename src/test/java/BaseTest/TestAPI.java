package BaseTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utils.ExtendreportListener;
import utils.Fileanddev;
@Listeners(ExtendreportListener.class)
public class TestAPI extends ExtendreportListener {
	//@Test
	public void utilTest() {
	System.out.println(Fileanddev.endev());
	}
	//@Test
	public void sumTest() {
int a=10,b=20,sum;
sum=a+b;
	
test.log(LogStatus.INFO, "Calculating");
test.log(LogStatus.PASS, "Sum calculated"+sum);

		}
}
