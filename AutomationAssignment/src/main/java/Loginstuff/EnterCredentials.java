package Loginstuff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterCredentials {
	
	public WebDriver driver;
	
	//for user name
	By Name=By.xpath("//input[@name='customerName']");
	
	//for number
	By Number=By.xpath("//input[@name='email']");
	
	//for password
	By password=By.xpath("//input[@name='password']");
	
	//for Submit
	By submit=By.xpath("//input[@type='submit']");
	
	public EnterCredentials(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement EnterName()
	{
		return driver.findElement(Name);
	}
	
	public WebElement EnterPhone()
	{
		return driver.findElement(Number);
	}
	
	public WebElement EnterPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement EnterSubmit()
	{
		return driver.findElement(submit);
	}
}
