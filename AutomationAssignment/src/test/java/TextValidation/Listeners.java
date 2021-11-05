package TextValidation;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PreSetups.PreSettings;
import screenShot.takeScreenShot;


public class Listeners extends PreSettings implements ITestListener {

	public void onTestFailure(ITestResult result)
	{
		ExtentTest test3=extent.createTest(driver.getTitle());
		String screenshotpath=null;
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				screenshotpath=takeScreenShot.capture(driver, "screenshotforExtentReport");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test3.log(Status.FAIL, result.getThrowable());
			test3.fail("Test not matched",MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());

		}
	}
	

	public void onTestSuccess(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{


			ExtentTest test4=extent.createTest(driver.getTitle());
			String screenshotpath = null;
			try {
				screenshotpath = takeScreenShot.capture(driver, "screenshotforExtentReport");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test4.log(Status.PASS, result.getName());
			test4.pass("Test Succeeded",MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());

		}
	}
}


