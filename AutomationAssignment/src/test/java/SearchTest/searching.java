package SearchTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PreSetups.PreSettings;
import SearchingSomeProject.SearchProduct;


public class searching extends PreSettings{
	
	public static Logger log=LogManager.getLogger(PreSettings.class.getName());
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver=setthings();
		driver.get(prop.getProperty("Url"));
	}
	
	@Test(dataProvider="getvalue")
	public void srtest(String product) throws IOException
	{
	
		SearchProduct sp=new SearchProduct(driver);
		
		sp.Search().sendKeys(product);
		
		sp.SearchTabb().click();
		
		log.info("Product is searched");
		
	}
	
	@DataProvider
	public  Object[] getvalue()
	{
		String path=System.getProperty("user.dir");
		TakeValueFromExcel exc=new TakeValueFromExcel(path+"\\excel\\exceldata\\testc.xlsx","testcc");
		Object[] ob=new Object[2];
		ob[0]=exc.getData(0, 0);
		ob[1]=exc.getData(1, 1);
		System.out.println(exc.getData(0, 0));
		return ob;	
	}
	
	@AfterMethod
	public void closed()
	{
		driver.close();
	}

}
