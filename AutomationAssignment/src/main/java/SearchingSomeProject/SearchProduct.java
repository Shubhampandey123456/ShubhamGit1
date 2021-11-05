package SearchingSomeProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProduct {
	
	public WebDriver driver;

	//for search tab
	By Searching=By.xpath("//input[@id='twotabsearchtextbox']");
	
	//for clicking searchBox
	By searchTab=By.xpath("//input[@value='Go']");
	
	
	
	public SearchProduct(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement Search()
	{
		return driver.findElement(Searching);
	}
	
	public WebElement SearchTabb()
	{
		return driver.findElement(searchTab);
	}

}
