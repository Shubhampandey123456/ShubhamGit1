package Loginstuff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public WebDriver driver;
	
	//Click on login icon
	By loginicon=By.xpath("//a[@id='nav-link-accountList']");
	
	//clicking on create account
	By createNew=By.xpath("//a[@id='createAccountSubmit']");
	
	//Getting some text
	By text=By.xpath("//span[@id='glow-ingress-line2']");
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Clicklogin()
	{
		return driver.findElement(loginicon);
	}
	
	public WebElement ClickCreate()
	{
		return driver.findElement(createNew);
	}
	
	public WebElement getTexture()
	{
		return driver.findElement(text);
	}

}
