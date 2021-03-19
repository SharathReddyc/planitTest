package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage {

	
	public WebDriver driver;
	
	By loginUrl=By.xpath("//a[contains(text(),'Log in')]");
	
	
	
	
	
	
	public FirstPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	public WebElement getloginUrl()
	{
		return driver.findElement(loginUrl);
	}
	
	
	

	
	
}
