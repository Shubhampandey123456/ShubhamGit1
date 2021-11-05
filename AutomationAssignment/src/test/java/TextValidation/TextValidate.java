package TextValidation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Loginstuff.Login;
import PreSetups.PreSettings;
import screenShot.takeScreenShot;

public class TextValidate extends PreSettings{
	
	
	public static Logger log=LogManager.getLogger(PreSettings.class.getName());
	@BeforeMethod 
	public void initialize() throws IOException
	{
		driver=setthings();
		driver.get(prop.getProperty("Url"));
	}
	
	@Test
	public void Validation() throws InterruptedException
	{
		Login log1=new Login(driver);
		log.info("text displayed");
		Assert.assertEquals(log1.getTexture().getText(), "Selectour address");
		Thread.sleep(5000L);
	}
	
	@AfterMethod
	public void closed()
	{
		driver.close();
	}

}
