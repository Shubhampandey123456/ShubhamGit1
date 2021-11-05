package presettest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Loginstuff.EnterCredentials;
import Loginstuff.Login;
import PreSetups.PreSettings;


//extending Settingthings class to use its property

public class settingtest extends PreSettings{

	public static Logger log=LogManager.getLogger(PreSettings.class.getName());

	@BeforeMethod()
	public void initialize() throws IOException
	{
		
		driver = setthings();
		log.info("Driver is intialized");	
		driver.get(prop.getProperty("Url"));
		
	}



	@Test(dataProvider="getdata")
	public void browseropening(String naam,String phoneno, String pwd,String text) throws IOException, InterruptedException
	{



		//invoking login class
		Login op=new Login(driver);

		//creating a Extent test to see if url is validated
		ExtentTest test2=extent.createTest("Doing Login","This is test to Login");
		//clicking on login icon
		op.Clicklogin().click();

		//clicking on create account
		op.ClickCreate().click();

		//Enter Information
		EnterCredentials ec=new EnterCredentials(driver);

		Thread.sleep(2000L);
		ec.EnterName().sendKeys(naam);


		ec.EnterPhone().sendKeys(phoneno);

		ec.EnterPassword().sendKeys(pwd);

		ec.EnterSubmit().click();

		System.out.println(text);

		Thread.sleep(5000L);

		extent.flush();


	}

	@DataProvider
	public Object[][] getdata()
	{
		Object[][] ob=new Object[2][4];

		//Entering first credentials
		ob[0][0]="Shubham Pandey";
		ob[0][1]="6393575904";
		ob[0][2]="26142514251";
		ob[0][3]="Already Registered";

		//Enter Second Crenedtials
		ob[1][0]="Vijay";
		ob[1][1]="9005133219";
		ob[1][2]="2614255322";
		ob[1][3]="Successfully Created";

		return ob;
	}



	@AfterMethod
	public void closed()
	{
		driver.close();
	}






}
